package bo.edu.ucb.ingsoft.deliverybot.delivery.chat;

import bo.edu.ucb.ingsoft.deliverybot.delivery.bl.CategoryBl;
import bo.edu.ucb.ingsoft.deliverybot.delivery.bl.OrderBl;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateInOrderDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.util.UserSession;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Logger;

@Service
public class OrderPlateProcessImpl extends AbstractProcess {
    private CategoryBl categoryBl;
    private PlateDto plate;
    private PlateInOrderDto plateInOrder;
    private OrderBl orderBl;
    @Autowired
    public OrderPlateProcessImpl(PlateDto plate, CategoryBl categoryBl){
        this.categoryBl = categoryBl;
        this.setName("Selecion");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
//        this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
        this.plate = plate;
    }

    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, DeliveryLongPollingBot bot) {

        AbstractProcess result = this;
        Long chatId = update.getMessage().getChatId();


        if (this.getStatus().equals("STARTED")) {

            showOrderPlateProcess(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por un numero 1 o 2
            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasdas
                try {
                    int cantidad = Integer.parseInt(text);
                    if(cantidad == 0){
                        result = new ViewMenuSoupImpl(categoryBl);
                    }else {

                        orderBl = new OrderBl();
                       if (UserSession.get(chatId,"Lista") != null){
                           List<PlateInOrderDto> lista = (List<PlateInOrderDto>) UserSession.get(chatId,"Lista");
                           plateInOrder = new PlateInOrderDto(plate,cantidad);
                           orderBl.addPlateToList(lista,plateInOrder);

                       }else{
                           List<PlateInOrderDto> lista = new ArrayList<PlateInOrderDto>();
                           plateInOrder = new PlateInOrderDto(plate,cantidad);
                           orderBl.addPlateToList(lista,plateInOrder);
                           UserSession.put(chatId,"Lista",lista);
                       }
                       System.out.println("Esto es algo"+UserSession.get(chatId,"Lista"));
                        result = new ViewMenCategoryImpl(categoryBl);
                    }

                } catch (NumberFormatException ex) {
                    showOrderPlateProcess(bot, chatId);
                }
                // continuar con el proceso seleccionado
            } else { // Si me enviaron algo diferente de un texto.
                showOrderPlateProcess(bot, chatId);
            }
        }
        return result;
    }

    private void showOrderPlateProcess(DeliveryLongPollingBot bot, Long chatId){
        List<PlateDto> order = CategoryBl.CategorySoup();
        StringBuffer sb = new StringBuffer();
        sb.append("Usted Selecciono \r\n");
        sb.append("Nombre: "+ plate.getNombre()).append("\n\r");
        sb.append("Precio: "+plate.getPrecio() + " Bs").append("\n\r");
        sb.append("Descripcion: "+plate.getDescripcion()).append("\n\r");
        sb.append("\n");
        sb.append("0: atras").append("\n\r");
        sb.append("\n");
        sb.append("Seleccione la cantidad que desea: ");
        sb.append("\n");
        sendPhotoB(bot,chatId,plate.getImg(), String.valueOf(sb));
//        sendStringBuffer(bot,chatId,sb);
        sb.setLength(0);
        this.setStatus("AWAITING_USER_RESPONSE");
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
