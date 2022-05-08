package bo.edu.ucb.ingsoft.deliverybot.delivery.chat;

import bo.edu.ucb.ingsoft.deliverybot.delivery.bl.ClientBl;
import bo.edu.ucb.ingsoft.deliverybot.delivery.bl.OrderBl;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.ClientDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.OrderDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateInOrderDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.util.UserSession;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderDataProcessImpl extends AbstractProcess {
    private OrderBl orderBl;
    private ClientBl clientBl;
    private int datos = 0;
    public static Logger logger = LoggerFactory.getLogger(OrderDataProcessImpl.class);
    @Autowired
    public OrderDataProcessImpl( ClientBl clientBl, OrderBl orderBl){
        this.orderBl = orderBl;
        this.clientBl = clientBl;
        this.setName("Registrar datos del pedido");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setStatus("STARTED");
    }
    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, DeliveryLongPollingBot bot) {
        int t = 0;
        AbstractProcess result = this;
        ClientDto cliente = null;
        OrderDto order = null;
        Long chatId = update.getMessage().getChatId();
        // sigo en el mismo proceso.
        if (UserSession.get(chatId,"process_status").equals(UserSession.started)) {
        logger.info("aqui llego");
            showMenu(bot, chatId);
        } else if (UserSession.get(chatId,"process_status").equals(UserSession.awaiting_response)) {
            // Estamos esperando por un numero 1 o 2
            Message message = update.getMessage();
            if ( message.hasText() || message.hasLocation() ) {
                // Intentamos transformar en número
                String text = message.getText();
                UserSession.put(chatId,"process_status",UserSession.started);
                try {
                    switch (datos){
                            case 0: t  = Integer.parseInt(text);
                                logger.info("Valor de t {}",t);
                                UserSession.put(chatId,"pago",t);
                                logger.info("Pago:{} ",UserSession.get(chatId,"pago"));
                                datos++;
                                break;
                            case 1:
                                t  = Integer.parseInt(text); UserSession.put(chatId,"delivery",t);
                                logger.info("Delivery:{} ",UserSession.get(chatId,"delivery"));
                                if((int)UserSession.get(chatId,"delivery") == 1){
                                    cliente = newClient(chatId);
                                    order = newOrder(cliente,chatId);
                                    showOrderInfo(bot,chatId,order,cliente);
                                    datos = 3;
                                }
                                if((int)UserSession.get(chatId,"delivery") == 2){
                                    datos ++;
                                }
                                break;
                            case 2:
                                if(message.hasLocation()){
                                    logger.info("valor de delivery: {}",UserSession.get(chatId,"delivery"));
                                    Double lat = update.getMessage().getLocation().getLatitude(), lon =  update.getMessage().getLocation().getLongitude();
                                    logger.info(String.valueOf(lat));
                                    logger.info(String.valueOf(lon));
                                    UserSession.put(chatId,"lat",lat);
                                    UserSession.put(chatId,"lon",lon);
                                    cliente = newClient(chatId);
                                    order = newOrder(cliente,chatId);
                                    showOrderInfo(bot,chatId,order,cliente);
                                    datos++;

                                }
                                break;

                            //lat y long
                            case 3: switch (text){
                                case "1": logger.info("Se guarda la informacion");
                                    cliente = newClient(chatId);
                                    order = newOrder(cliente,chatId);
                                    orderBl.saveOrder(order,cliente);
                                    datos++;
                                    break;
                                case "2":
                                    logger.info("NO!!! Se guarda la informacion");
                                    datos = 0;
                                    break;
                                case "3":
                                            UserSession.put(chatId,"process_status",UserSession.started);
                                            datos = 0;
                                            return context.getBean(MenuProcessImpl.class);

                            }
                           break;

                    }
                   logger.info("posicion de los datos: {}",datos);
                    if(datos <4){
                        showMenu(bot, chatId);
                    }else
                    {

                        showConfMessage(bot,chatId);
                        UserSession.put(chatId,"process_status",UserSession.started);
                        result = context.getBean(MenuProcessImpl.class);
                        datos = 0;
                    }
                } catch (NumberFormatException ex) {
                    showMenu(bot, chatId);
                }
                // continuar con el proceso seleccionado
            } else { // Si me enviaron algo diferente de un texto.
                showMenu(bot, chatId);
            }
        }
        return result;

    }
    private void showMenu(DeliveryLongPollingBot bot, Long chatId){

        StringBuffer sb = new StringBuffer();

        switch (datos){

            case 0: sb.append("Ingrese metodo de pago: \n\r");
                     sb.append("1.Pago QR\n\r");
                     sb.append("2.Pago en el local\n\r");break;
            case 1: sb.append("Seleccione el tipo de entrega: \n\r");
                    sb.append("1.Entrega en local\n\r");
                    sb.append("2.Delivery\n\r");break;
            case 2: sb.append("Mande la dirección de entrega (como ubicacion): \n\r");break;
            case 3: sb.append("1.Guardar\n\r");
                    sb.append("2.Reintroducir Informacion\n");
                    sb.append("3.Salir");
                    break;
           // case 4: sb.append("Pedido Enviado esperando Confirmation"); break;
        }
        sendStringBuffer(bot,chatId,sb);
        UserSession.put(chatId,"process_status",UserSession.awaiting_response);
    }

    private void showConfMessage(DeliveryLongPollingBot bot, long chatId){
        StringBuffer sb = new StringBuffer();
        sb.append("Pedido Enviado, esperando Confirmacion\r");
        sendStringBuffer(bot,chatId,sb);
        UserSession.put(chatId,"process_status",UserSession.awaiting_response);
    }
    private void showOrderInfo(DeliveryLongPollingBot bot, long chatId, OrderDto order, ClientDto client){
        StringBuffer sb = new StringBuffer();
        sb.append(order.toStringClient(client));
        sendStringBuffer(bot,chatId,sb);
    }
    private ClientDto newClient(long chatId){
        ClientDto cliente;
        if((boolean) UserSession.get(chatId,"nuevo_cliente") ){
            cliente = clientBl.createClientDto(
                    (String) UserSession.get(chatId,"nombre"),
                    (String) UserSession.get(chatId,"nit"),
                    (String) UserSession.get(chatId,"telefono"),
                    chatId);
        }
        else {
            cliente = clientBl.createClientDto(
                    (int) UserSession.get(chatId,"id"),
                    (String) UserSession.get(chatId,"nombre"),
                    (String) UserSession.get(chatId,"nit"),
                    (String) UserSession.get(chatId,"telefono"),
                    chatId);

        }
        return cliente;
    }
    private OrderDto newOrder(ClientDto cliente,long chatId){

        OrderDto order = orderBl.createOrder(
                cliente,
                (List<PlateInOrderDto>) UserSession.get(chatId,"Lista"),
                (Double)UserSession.get(chatId,"lat"),
                (Double)UserSession.get(chatId,"lon"),
                (int) UserSession.get(chatId,"pago"),
                (int) UserSession.get(chatId,"delivery"));

        return  order;
    }

    @Override
    public AbstractProcess onError() {
        return null;
    }

    @Override
    public AbstractProcess onSuccess() {
        return null;
    }

    @Override
    public AbstractProcess onTimeout() {
        return null;
    }
}
