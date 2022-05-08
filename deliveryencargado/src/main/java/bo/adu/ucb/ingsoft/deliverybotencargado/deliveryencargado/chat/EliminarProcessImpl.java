package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.chat;

import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.bl.PlatoBl;
import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto.PlatoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class EliminarProcessImpl extends AbstractProcess{
    private PlatoBl platoBl;
    private PlatoDto platoDto;

    @Autowired
    EliminarProcessImpl(PlatoDto platoDto, PlatoBl platoBl){
        this.platoBl = platoBl;
        this.setName("EditarPlatos");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
//      this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
        this.platoDto = platoDto;
    }

    private void showMainMenu(DeliveryLongPollingBot bot, Long chatId){

        StringBuffer sb = new StringBuffer();
        sb.append("Esta seguro de eliminar el siguiente plato:\r\n");
        sb.append("Nombre: "+ platoDto.getNombre()).append("\n\r");
        sb.append("Precio: "+platoDto.getPrecio() + " Bs").append("\n\r");
        sb.append("Descripcion: "+platoDto.getDescripcion()).append("\n\r");
        sb.append("Imagen(URL): "+platoDto.getImg()).append("\n\r");
        sb.append("Categoria: "+platoDto.getCategoria()).append("\n\r");
        sb.append("\n");
        sb.append("0. atras").append("\n\r");
        sb.append("1. borrar").append("\n\r");
        sendPhotoB(bot,chatId,platoDto.getImg(), String.valueOf(sb));
        sb.setLength(0);
        this.setStatus("AWAITING_USER_RESPONSE");
    }

    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, DeliveryLongPollingBot bot) {
        AbstractProcess result = this; // sigo en el mismo proceso.
        Long chatId = update.getMessage().getChatId();
        if (this.getStatus().equals("STARTED")) {

            showMainMenu(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por un numero 1 o 2
            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasdas
                try {
                    int opcion = Integer.parseInt(text);
                    switch (opcion){
                        case 0 :
                            result = new MenuEncargadoProcessImpl();
                            break;
                        case 1 :
                            platoBl.eliminarPlato(platoDto);
                            System.out.println(platoDto.getId());
                            result = new MenuEncargadoProcessImpl();
                            break;
//                        case 3: result = new MenuOrderProcessImpl(); break;
                        default: showMainMenu(bot, chatId); break;
                    }
                } catch (NumberFormatException ex) {
                    showMainMenu(bot, chatId);
                }
                // continuar con el proceso seleccionado
            } else { // Si me enviaron algo diferente de un texto.
                showMainMenu(bot, chatId);
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
