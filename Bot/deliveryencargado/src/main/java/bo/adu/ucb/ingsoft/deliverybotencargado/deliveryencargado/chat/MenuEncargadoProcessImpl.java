package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.chat;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;

@Service
public class MenuEncargadoProcessImpl extends AbstractProcess{
    public MenuEncargadoProcessImpl() {
        this.setName("Menú principal");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
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
//                        case 1 : result = context.getBean(PedidoProcessImpl.class);
//                            break;
//                        case 2 : result = context.getBean(AboutProcessImpl.class);
//                            break;
                        case 1 : result = context.getBean(AgregarPlatoProcessImpl.class);
                            break;
                        case 2 : result = context.getBean(EditarPlatoProcessImpl.class);
                            break;
                        case 3 : result = context.getBean(EliminarPlatoProcessImpl.class);
                            break;
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

    private void showMainMenu(DeliveryLongPollingBot bot, Long chatId) {
        StringBuffer sb = new StringBuffer();
        sb.append("Bot Delivery Encargado\r\n");
        //sb.append("1. Pedidos\r\n");
        //sb.append("2. Modificar Menu \r\n");
        sb.append("1. Agregar Plato \r\n");
        sb.append("2. Editar Plato \r\n");
        sb.append("3. Eliminar Plato \r\n");
        sb.append("Elija una opción:\r\n");
        sendStringBuffer(bot, chatId, sb);

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
