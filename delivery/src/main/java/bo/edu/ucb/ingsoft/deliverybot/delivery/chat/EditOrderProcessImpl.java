package bo.edu.ucb.ingsoft.deliverybot.delivery.chat;

import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.ClientDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateInOrderDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.util.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EditOrderProcessImpl extends AbstractProcess{
    public Logger logger = LoggerFactory.getLogger(EditOrderProcessImpl.class);
    public EditOrderProcessImpl() {
        this.setName("Editar Pedido");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setStatus("STARTED");
    }
    private void showMenu(DeliveryLongPollingBot bot, Long chatId){
        List<PlateInOrderDto> list = (List<PlateInOrderDto>) UserSession.get(chatId,"Lista");
        StringBuffer sb = new StringBuffer();
            int c = 1;
            BigDecimal total = new BigDecimal("0.0") ,aux ;


            sb.append("---Pedido---\r\n\n");
            for(PlateInOrderDto plate :list){
                sb.append("Nro ").append(c).append("\n");
                aux = plate.getPlato().getPrecio();
                aux = aux.multiply(BigDecimal.valueOf(plate.getCantidad()));
                total = total.add(aux);
                sb.append(plate.toString());
                sb.append("\n\n");
                c++;
            }
            sb.append("------------------------\n\r\n");
            sb.append("subtotal: ").append(total).append("Bs\n\r");
            sb.append("Envio: 10.00Bs\r\n");
            total = total.add(BigDecimal.valueOf(10));
            sb.append("Total: ").append(total).append("Bs\r\n");
            sendStringBuffer(bot,chatId,sb);
            sb.setLength(0);
            sb.append("Bot delivery\r\n");
            sb.append("Seleccione el plato a editar\r\n");
            sb.append("0. Volver");





        sendStringBuffer(bot, chatId, sb);
        UserSession.put(chatId,"process_status",UserSession.awaiting_response);
        this.setStatus("AWAITING_USER_RESPONSE");
    }
    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, DeliveryLongPollingBot bot) {
        AbstractProcess result = this;
        Long chatId = update.getMessage().getChatId();
        // sigo en el mismo proceso.
        if (UserSession.get(chatId,"process_status").equals(UserSession.started)) {

            showMenu(bot, chatId);
        } else if (UserSession.get(chatId,"process_status").equals(UserSession.awaiting_response)) {
            // Estamos esperando por un numero 1 o 2
            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasdas
                try {
                    UserSession.put(chatId,"process_status",UserSession.started);
                        logger.info("texto: {}",text);
                        int opcion = Integer.parseInt(text);
                        List<PlateInOrderDto> list = (List<PlateInOrderDto>)UserSession.get(chatId,"Lista");
                        if(opcion != 0){
                            if(opcion <= list.size()){
                                UserSession.put(chatId,"plato_index",opcion);
                                return context.getBean(EditPlateProcessImpl.class);
                            }
                            else {
                                showMenu(bot, chatId);
                            }
                        }else{
                            return context.getBean(MenuOrderProcessImpl.class);
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
