package bo.edu.ucb.ingsoft.deliverybot.delivery.chat;

import bo.edu.ucb.ingsoft.deliverybot.delivery.bl.ClientBl;
import bo.edu.ucb.ingsoft.deliverybot.delivery.bl.OrderBl;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.ClientDto;
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
        Long chatId = update.getMessage().getChatId();
        // sigo en el mismo proceso.
        if (this.getStatus().equals("STARTED")) {
        logger.info("aqui llego");
            showMenu(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por un numero 1 o 2
            Message message = update.getMessage();
            if ( message.hasText() || message.hasLocation() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasdas

                try {
                    switch (datos){
                        case 0: t  = Integer.parseInt(text); UserSession.put(chatId,"pago",t);
                            logger.info(String.valueOf((Integer) UserSession.get(chatId,"pago")));datos++;break;
                        case 1:  t  = Integer.parseInt(text); UserSession.put(chatId,"delivery",t);
                            logger.info(String.valueOf((Integer) UserSession.get(chatId,"delivery")));datos++;break;
                        case 2: Double lat = update.getMessage().getLocation().getLatitude(), lon =  update.getMessage().getLocation().getLongitude();
                            logger.info(String.valueOf(lat));
                            logger.info(String.valueOf(lon));
                            UserSession.put(chatId,"lat",lat);
                            UserSession.put(chatId,"lon",lon);
                            datos++;
                            break; //lat y long
                        case 3: if(text.equals("1")){
                            logger.info("Se guarda la informacion");
                            orderBl.createOrder(
                                    clientBl.createClientDto(
                                            (String) UserSession.get(chatId,"nombre"),
                                            (String) UserSession.get(chatId,"nit"),
                                            (String) UserSession.get(chatId,"telefono"),
                                            chatId),
                                    (List<PlateInOrderDto>) UserSession.get(chatId,"Lista"),
                                    (Double)UserSession.get(chatId,"lat"),
                                    (Double)UserSession.get(chatId,"lon"),
                                    (int) UserSession.get(chatId,"pago"),
                                    (int) UserSession.get(chatId,"delivery"));
                                    datos++;
                                }
                                if(text.equals("2")){
                            logger.info("NO!!! Se guarda la informacion");
                                    datos = 0;

                            }
                        case 4: showConfMessage(bot,chatId);  result = context.getBean(MenuProcessImpl.class);break;
                    }

                    if(datos <4){
                        showMenu(bot, chatId);
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
        ClientDto client = clientBl.getClientData(chatId);
        switch (datos){

            case 0: sb.append("Ingrese metodo de pago: \n\r");
                     sb.append("1.Pago QR\n\r");
                     sb.append("2.Pago en el local\n\r");break;
            case 1: sb.append("Seleccione el tipo de entrega: \n\r");
                    sb.append("1.Entrega en local\n\r");
                    sb.append("2.Delivery\n\r");break;
            case 2: sb.append("Mande la dirección de entrega (como ubicacion): \n\r");break;
            case 3: sb.append("1.Guardar\n\r");
                    sb.append("2.Cancelar");
                    break;
            case 4: sb.append("Pedido Enviado esperando Confirmation");
        }

        sendStringBuffer(bot,chatId,sb);
        this.setStatus("AWAITING_USER_RESPONSE");
    }

    private void showConfMessage(DeliveryLongPollingBot bot, long chatId){
        StringBuffer sb = new StringBuffer();
        sb.append("Pedido Enviado, esperando Confirmacion");
        sendStringBuffer(bot,chatId,sb);
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
