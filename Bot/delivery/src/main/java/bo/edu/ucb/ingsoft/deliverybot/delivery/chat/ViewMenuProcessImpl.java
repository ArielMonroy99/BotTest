package bo.edu.ucb.ingsoft.deliverybot.delivery.chat;

import bo.edu.ucb.ingsoft.deliverybot.delivery.bl.PlateBl;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateInOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ViewMenuProcessImpl extends AbstractProcess{
    private PlateBl plateBl;
    @Autowired
    ViewMenuProcessImpl(PlateBl plateBl){
        this.plateBl = plateBl;
        this.setName("Platos del menu");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);

//      this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    private void showMenuRestaurant(DeliveryLongPollingBot bot, Long chatId){

        List<PlateDto> menuToday = plateBl.TodayMenu();
        StringBuffer sb = new StringBuffer();
        sb.append("Menu del dia \r\n");
        sendStringBuffer(bot,chatId,sb);
        sb.setLength(0);
        menuToday.forEach(plate->{

            sb.append(plate.getId()+": "+"Nombre: "+ plate.getNombre()).append("\n\r");
            sb.append("Precio: "+plate.getPrecio() + " Bs").append("\n\r");
            sb.append("Descripcion: "+plate.getDescripcion()).append("\n\r");
            sendPhotoB(bot,chatId,plate.getImg(), String.valueOf(sb));
            sb.append("\n");
            sb.setLength(0);
        });
        sb.append("Selecione un plato").append("\n\r");
        sb.append("0: Salir").append("\n\r");
        sendStringBuffer(bot,chatId,sb);
        this.setStatus("AWAITING_USER_RESPONSE");
    }

    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, DeliveryLongPollingBot bot) {
        AbstractProcess result = this;
        Long chatId = update.getMessage().getChatId();


        if (this.getStatus().equals("STARTED")) {

            showMenuRestaurant(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por un numero 1 o 2
            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasda
                try {
                    int opcion = Integer.parseInt(text);
                    List<PlateDto> menuToday = plateBl.TodayMenu();
                    if (opcion == 0){
                        result = new MenuProcessImpl();
                    }else{
//                        result = new OrderPlateProcessImpl(menuToday.get(opcion-1), plateBl);
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
