package bo.edu.ucb.ingsoft.deliverybot.delivery.chat;

import bo.edu.ucb.ingsoft.deliverybot.delivery.bl.OrderBl;
import bo.edu.ucb.ingsoft.deliverybot.delivery.bl.PlateBl;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.OrderDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateDto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;


public class ViewMenuProcessImpl extends AbstractProcess{

    ViewMenuProcessImpl(){
        this.setName("Platos del menu");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
//        this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    @Override
    public AbstractProcess handle(Update update, DeliveryLongPollingBot bot) {
        AbstractProcess result = this;
        Long chatId = update.getMessage().getChatId();


        if (this.getStatus().equals("STARTED")) {

            showMenuRestaurant(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por un numero 1 o 2
            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasdas
                try {
                    int opcion = Integer.parseInt(text);
                    switch (opcion){
                        case 1 :  this.sendStringBuffer(bot,chatId,new StringBuffer("Pedido Enviado"));
                            result = new MenuProcessImpl();
                            break;
                        case 2 : result = new MenuOrderProcessImpl();
                            break;

                        default: showMenuRestaurant(bot, chatId);
                    }
                } catch (NumberFormatException ex) {
                    showMenuRestaurant(bot, chatId);
                }
                // continuar con el proceso seleccionado
            } else { // Si me enviaron algo diferente de un texto.
                showMenuRestaurant(bot, chatId);
            }
        }
        return result;
    }

    private void showMenuRestaurant(DeliveryLongPollingBot bot, Long chatId){
        PlateBl plateBl = new PlateBl();
        List<PlateDto> menuToday = plateBl.TodayMenu(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("Menu del dia \r\n");
        menuToday.forEach(plate->{

            sb.append(plate.getId()+": "+"Nombre: "+ plate.getNombre()).append("\n\r");
            sb.append("Precio: "+plate.getPrecio() + " Bs").append("\n\r");
            sb.append("Descripcion: "+plate.getDescripcion()).append("\n\r");
            sb.append("\n");
        });
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
