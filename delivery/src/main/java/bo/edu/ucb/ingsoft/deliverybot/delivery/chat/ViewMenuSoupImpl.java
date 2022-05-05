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
public class ViewMenuSoupImpl extends AbstractProcess{

private CategoryBl categoryBl;
    @Autowired
    ViewMenuSoupImpl(CategoryBl categoryBl){
        this.categoryBl = categoryBl;
        this.setName("Categoria de Sopa");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
//      this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    private void showMenuSoup(DeliveryLongPollingBot bot, Long chatId){

        List<PlateDto> menuSoup = CategoryBl.CategorySoup();
        StringBuffer sb = new StringBuffer();
        sb.append("Menu de Sopas \r\n");
        sendStringBuffer(bot,chatId,sb);
        sb.setLength(0);
        menuSoup.forEach(plate->{

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

            showMenuSoup(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por un numero 1 o 2
            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasda
                try {
                    int opcion = Integer.parseInt(text);
                    List<PlateDto> menuSoup = CategoryBl.CategorySoup();
//                    for (int i = 0; i <= menuToday.size() ; i++) {
//                        if (opcion == i){
//                            System.out.println();
//                        }
//
//                    }
                    if (opcion == 0){
                        result = new ViewMenCategoryImpl(categoryBl);
                    }else{
                        result = new OrderPlateProcessImpl(menuSoup.get(opcion-1), categoryBl);
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
