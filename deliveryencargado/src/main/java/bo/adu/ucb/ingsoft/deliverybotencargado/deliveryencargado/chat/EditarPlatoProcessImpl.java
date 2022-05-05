package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.chat;


import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.bl.PlatoBl;
import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto.PlatoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
public class EditarPlatoProcessImpl extends AbstractProcess{
    private PlatoBl platoBl;

    @Autowired
    EditarPlatoProcessImpl(PlatoBl platoBl){
        this.platoBl = platoBl;
        this.setName("EditarPlatos");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
//      this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    private void showMenuRestaurant(DeliveryLongPollingBot bot, Long chatId){

        List<PlatoDto> menuT = platoBl.TodayMenu();
        StringBuffer sb = new StringBuffer();
        sb.append("Menu del dia \r\n");
        sendStringBuffer(bot,chatId,sb);
        sb.setLength(0);
        menuT.forEach(menu->{

            sb.append(menu.getId()+": "+"Nombre: "+ menu.getNombre()).append("\n\r");
            sb.append("Precio: "+menu.getPrecio() + " Bs").append("\n\r");
            sb.append("Descripcion: "+menu.getDescripcion()).append("\n\r");
            sendPhotoB(bot,chatId,menu.getImg(), String.valueOf(sb));
            sb.append("\n");
            sb.setLength(0);
        });
        sb.append("Selecione el plato que desea editar ").append("\n\r");
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
                    List<PlatoDto> menuT = platoBl.TodayMenu();
                    if (opcion == 0){
                        result = new MenuProcessImpl();
                    }
                    else{

                        result = new EditarProcessImpl(menuT.get(opcion-1),platoBl);
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
