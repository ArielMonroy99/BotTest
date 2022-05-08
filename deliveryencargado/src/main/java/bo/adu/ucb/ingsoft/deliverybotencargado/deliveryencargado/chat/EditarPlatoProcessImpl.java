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
    int cont=1,cen=0,cate=0;
    List<PlatoDto> menuT = null;

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
        StringBuffer sb = new StringBuffer();
        if (cen==0){
            sb.append("Categoria: \r\n");
            sb.append("1. Sopa \r\n");
            sb.append("2 Plato Principal \r\n");
            sb.append("3 Postre \r\n");
        }
        else{
            switch (cate){
                case 1 :
                    menuT = platoBl.Sopa();
                    break;
                case 2 :
                    menuT = platoBl.Principal();
                    break;
                case 3 :
                    menuT = platoBl.Postre();
                    break;
            }

            sb.append("Menu del dia \r\n");
            sendStringBuffer(bot,chatId,sb);
            sb.setLength(0);
            menuT.forEach(menu->{

                sb.append(cont +": "+"Nombre: "+ menu.getNombre()).append("\n\r");
                sb.append("Precio: "+menu.getPrecio() + " Bs").append("\n\r");
                sb.append("Descripcion: "+menu.getDescripcion()).append("\n\r");
                sendPhotoB(bot,chatId,menu.getImg(), String.valueOf(sb));
                sb.append("\n");
                sb.setLength(0);
                cont++;
            });
            sb.append("Selecione el plato que desea editar ").append("\n\r");
            sb.append("0: Salir").append("\n\r");
        }
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
                cont=1;
                this.setStatus("STARTED");
                try {
                    int opcion = Integer.parseInt(text);
                    if (cen==0){
                        switch (opcion){
                            case 1 :
                                cate=1;
                                cen=1;
                                showMenuRestaurant(bot, chatId);
                                break;
                            case 2 :
                                cate=2;
                                cen=1;
                                showMenuRestaurant(bot, chatId);
                                break;
                            case 3 :
                                cate=3;
                                cen=1;
                                showMenuRestaurant(bot, chatId);
                                break;
                            default: showMenuRestaurant(bot, chatId); break;
                        }

                    }
                    else {
                        if (opcion == 0){
                            cen=0;
                            result = new MenuProcessImpl();
                        }
                        else{
                            cen=0;
                            result = new EditarProcessImpl(menuT.get(opcion-1),platoBl);
                        }
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
