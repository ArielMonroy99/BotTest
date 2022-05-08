package bo.edu.ucb.ingsoft.deliverybot.delivery.chat;

import bo.edu.ucb.ingsoft.deliverybot.delivery.util.UserSession;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;

@Service
public class MenuOrderProcessImpl extends AbstractProcess{

    public MenuOrderProcessImpl() {
        this.setName("Menú de Pedidos");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    private void showOrderMenu(DeliveryLongPollingBot bot,Long chatId){
        StringBuffer sb = new StringBuffer();
        sb.append("Bot Delivery -- Menú de Pedidos\r\n");
        sb.append("1. Ver Pedido Actual\r\n");
        sb.append("2. Ver Pedido Anteriores\r\n");
        sb.append("3. Volver al Menu Principal\r\n");
        sb.append("Elija una opción:\r\n");
        sendStringBuffer(bot,chatId,sb);
        UserSession.put(chatId,"process_status",UserSession.awaiting_response);
    }
    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, DeliveryLongPollingBot bot) {

        AbstractProcess result = this; // sigo en el mismo proceso.
        Long chatId = update.getMessage().getChatId();

        if ( UserSession.get(chatId,"process_status").equals(UserSession.started)) {
            showOrderMenu(bot, chatId);
        } else if (UserSession.get(chatId,"process_status").equals(UserSession.awaiting_response)) {
            // Estamos esperando por un numero 1 o 2
            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasdas
                try {
                    UserSession.put(chatId,"process_status",UserSession.started);
                    int opcion = Integer.parseInt(text);
                    switch (opcion){
                        case 1 : result = context.getBean(OrderProcessImpl.class);
                        break;
                         case 2 : result = context.getBean(LastOrdersProcessImpl.class);
                          break;

                        case 3: result = new MenuProcessImpl(); break;
                        default: showOrderMenu(bot, chatId);
                    }
                } catch (NumberFormatException ex) {
                    showOrderMenu(bot, chatId);
                }
                // continuar con el proceso seleccionado
            } else { // Si me enviaron algo diferente de un texto.
                showOrderMenu(bot, chatId);
            }
        }else{
            showOrderMenu(bot, chatId);
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
