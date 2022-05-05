package bo.edu.ucb.ingsoft.deliverybot.delivery.chat;

import bo.edu.ucb.ingsoft.deliverybot.delivery.bl.CategoryBl;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
public class ViewMainMenuImpl extends AbstractProcess{
    private CategoryBl categoryBl;
    @Autowired
    ViewMainMenuImpl(CategoryBl categoryBl){
        this.categoryBl = categoryBl;
        this.setName("Categoria de plato principal");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
//      this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    private void showMenuSoup(DeliveryLongPollingBot bot, Long chatId){

        List<PlateDto> menuMain = CategoryBl.CategoryMain();
        StringBuffer sb = new StringBuffer();
        int i = 1;
        sb.append("Menu de platos principales \r\n");
        sendStringBuffer(bot,chatId,sb);
        sb.setLength(0);
        for(PlateDto plate : menuMain){

            sb.append(i +": "+"Nombre: "+ plate.getNombre()).append("\n\r");
            sb.append("Precio: "+plate.getPrecio() + " Bs").append("\n\r");
            sb.append("Descripcion: "+plate.getDescripcion()).append("\n\r");
            sendPhotoB(bot,chatId,plate.getImg(), String.valueOf(sb));
            sb.append("\n");
            sb.setLength(0);
            i++;
        }
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

            showMenuSoup(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por un numero 1 o 2
            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasda
                try {
                    int opcion = Integer.parseInt(text);
                    List<PlateDto> menuMain = CategoryBl.CategoryMain();
                    if (opcion == 0){
                        result = new ViewMenCategoryImpl(categoryBl);
                    }else{
                        result = new OrderPlateProcessImpl(menuMain.get(opcion-1), categoryBl);
                    }
                } catch (NumberFormatException ex) {
                    showMenuSoup(bot, chatId);
                }
                // continuar con el proceso seleccionado
            } else { // Si me enviaron algo diferente de un texto.
                showMenuSoup(bot, chatId);
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
