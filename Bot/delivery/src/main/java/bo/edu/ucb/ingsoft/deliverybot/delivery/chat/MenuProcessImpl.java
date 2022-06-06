package bo.edu.ucb.ingsoft.deliverybot.delivery.chat;

import bo.edu.ucb.ingsoft.deliverybot.delivery.util.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;

@Service
public class MenuProcessImpl extends AbstractProcess {

    public Logger logger = LoggerFactory.getLogger(MenuProcessImpl.class);
    public MenuProcessImpl() {
        this.setName("Menú principal");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setUserData(new HashMap<>());
        this.setStatus("STARTED");

    }

    // Retornar un Widget de tipo menu
//    @Override
//    public AbstractWidget onInit() {
//        MenuWidgetImpl menuWidget = new MenuWidgetImpl(messages);
//        return menuWidget;
//    }


    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, DeliveryLongPollingBot bot) {
        AbstractProcess result = this; // sigo en el mismo proceso.
        Long chatId = update.getMessage().getChatId();

        if (UserSession.get(chatId,"process_status").equals(UserSession.started)) {
            logger.info("estado del proceso para el chatID {} : {} ",chatId,UserSession.get(chatId,"process_status"));
            showMainMenu(bot, chatId);
           // logger.info("estado del proceso para el chatID {} : {} ",chatId,UserSession.get(chatId,"process_status"));
        } else if (UserSession.get(chatId,"process_status").equals(UserSession.awaiting_response)) {
            // Estamos esperando por un numero 1 o 2
            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                UserSession.put(chatId,"process_status",UserSession.started);
                String text = message.getText();
                logger.info("selecciono la opcion {}",text);
                try {
                    int opcion = Integer.parseInt(text);

                    switch (opcion){
                        case 1 : result = context.getBean(ViewMenCategoryImpl.class);
                            break;
                        case 2 : result = context.getBean(AboutProcessImpl.class);
                            break;
                        case 3: result = context.getBean(MenuOrderProcessImpl.class); break;
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
        sb.append("Bot delivery\r\n");
        sb.append("1. Ver Menu\r\n");
        sb.append("2. Información del restaurante \r\n");
        sb.append("3. Ver pedidos\r\n");
        sb.append("Elija una opción:\r\n");
        sendStringBuffer(bot, chatId, sb);

        UserSession.put(chatId,"process_status",UserSession.awaiting_response);
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
