package bo.edu.ucb.ingsoft.deliverybot.delivery.chat;

import bo.edu.ucb.ingsoft.deliverybot.delivery.bl.CategoryBl;
import bo.edu.ucb.ingsoft.deliverybot.delivery.util.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ViewMenCategoryImpl extends AbstractProcess{
    private CategoryBl categoryBl;
    public Logger logger = LoggerFactory.getLogger(ViewMenCategoryImpl.class);
    ViewMenCategoryImpl(CategoryBl categoryBl){
        this.categoryBl = categoryBl;

        this.setName("Categoria de platos");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
//      this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    private void showMainMenuCategory(DeliveryLongPollingBot bot, Long chatId) {
        StringBuffer sb = new StringBuffer();
        sb.append("Selecione la categoria\r\n");
        sb.append("1. Menu de sopas\r\n");
        sb.append("2. Menu de platos principales \r\n");
        sb.append("3. Menu de postres\r\n");
        sb.append("0. Atras\r\n");
        sb.append("Elija una opción:\r\n");
        sendStringBuffer(bot, chatId, sb);

        this.setStatus("AWAITING_USER_RESPONSE");
    }

    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, DeliveryLongPollingBot bot) {
        AbstractProcess result = this;
        Long chatId = update.getMessage().getChatId();
        logger.info("Estado del proceso {}",this.getStatus());
        if (this.getStatus().equals("STARTED")) {
            logger.info("estado del proceso para el chatID {} : {} ",chatId, UserSession.get(chatId,"process_status"));
            showMainMenuCategory(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por un numero 1 o 2
//            showMainMenuCategory(bot,chatId);
            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasda
                logger.info("selecciono la categoria {}",text);
                try {
                    int opcion = Integer.parseInt(text);
                    this.setStatus("STARTED");
                    switch (opcion){
                        case  0:
                            result = context.getBean(MenuProcessImpl.class);
                            break;
                        case 1: result = new ViewMenuSoupImpl(categoryBl);
                            break;
                        case 2: result = new ViewMainMenuImpl(categoryBl);
                            break;
                        case 3: result = new ViewMenuDessertImpl(categoryBl);
                            break;
                        default: showMainMenuCategory(bot, chatId);
                            break;
                    }
                } catch (NumberFormatException ex) {
                    showMainMenuCategory(bot, chatId);
                }
                // continuar con el proceso seleccionado
            } else { // Si me enviaron algo diferente de un texto.
                showMainMenuCategory(bot, chatId);
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
