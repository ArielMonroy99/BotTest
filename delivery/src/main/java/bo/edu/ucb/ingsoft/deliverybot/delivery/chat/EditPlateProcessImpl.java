package bo.edu.ucb.ingsoft.deliverybot.delivery.chat;

import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateDto;
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
public class EditPlateProcessImpl extends AbstractProcess {
    boolean editCantidad = false;
    public Logger logger = LoggerFactory.getLogger(EditPlateProcessImpl.class);
    public EditPlateProcessImpl() {
        this.setName("Editar Plato");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setStatus("STARTED");
    }
    private void showMenu(DeliveryLongPollingBot bot, Long chatId){
        List<PlateInOrderDto> list = (List<PlateInOrderDto>) UserSession.get(chatId,"Lista");
        StringBuffer sb = new StringBuffer();
        PlateInOrderDto plate = list.get((int) UserSession.get(chatId,"plato_index")-1);
        logger.info("editando cantidad {}", editCantidad);
        if(!editCantidad){
            sb.append(plate.getPlato().getNombre()).append("\n");
            sb.append(plate.getPlato().getDescripcion()).append("\n");
            sb.append("Precio: ").append(plate.getPlato().getPrecio()).append("\n");
            sb.append("Cantidad: ").append(plate.getCantidad()).append("\n");
            sb.append("--------------------------------------").append("\n");
            sb.append("1.Editar cantidad").append("\n");
            sb.append("2.Eliminar plato").append("\n");
            sb.append("0.Volver").append("\n");
        }else{
            sb.append("Ingrese la nueva cantidad:");
        }
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
                List<PlateInOrderDto> list = (List<PlateInOrderDto>) UserSession.get(chatId,"Lista");
                PlateInOrderDto plate = list.get((int) UserSession.get(chatId,"plato_index")-1);
                try {
                    UserSession.put(chatId,"process_status",UserSession.started);
                    int opcion = Integer.parseInt(text);
                    if(!editCantidad){
                        switch (opcion){
                            case 1 :editCantidad = true;
                                showMenu(bot,chatId);
                                  break;

                            case 2:
                                list.remove((int) UserSession.get(chatId,"plato_index")-1);
                                if(list.size()<1){
                                    UserSession.put(chatId,"Lista",null);
                                }
                                result = context.getBean(MenuOrderProcessImpl.class);

                                break;
                            case 0: return context.getBean(OrderProcessImpl.class);
                            default: showMenu(bot, chatId); break;

                    }}else{
                        plate.setCantidad(opcion);
                        editCantidad = false;
                        return  context.getBean(EditOrderProcessImpl.class);

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
