package bo.edu.ucb.ingsoft.deliverybot.delivery.chat;

import bo.edu.ucb.ingsoft.deliverybot.delivery.bl.ClientBl;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.ClientDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.util.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class NewClientDataProcessImpl extends AbstractProcess{
    private ClientBl clientBl;
    private int datos = 0;

    @Autowired
    public NewClientDataProcessImpl(ClientBl clientBl) {
        this.clientBl = clientBl;
        this.setName("Registrar datos del cliente");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setStatus("STARTED");
    }

    public NewClientDataProcessImpl() {

    }
    public Logger logger = LoggerFactory.getLogger(NewClientDataProcessImpl.class);
    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, DeliveryLongPollingBot bot) {

        AbstractProcess result = this;
        Long chatId = update.getMessage().getChatId();

        // sigo en el mismo proceso.
        if (UserSession.get(chatId,"process_status").equals(UserSession.started)) {
            showMenu(bot, chatId);
        } else if (UserSession.get(chatId,"process_status").equals(UserSession.awaiting_response)) {
            // Estamos esperando por un numero 1 o 2
            Message message = update.getMessage();
            if ( message.hasText()) {
                // Intentamos transformar en número
                String text = message.getText();
                try {
                    UserSession.put(chatId,"process_status",UserSession.started);
                    switch (datos){
                        case 0: UserSession.put(chatId,"nombre",text); datos++; logger.info("nombre:{}",text); break;

                        case 1: UserSession.put(chatId,"telefono",text); datos++; logger.info("telefono:{}",text);;break;
                        case 2: UserSession.put(chatId,"nit",text);datos++;  logger.info("nit:{}",text);break;
                        case 3: switch (text){
                                    case "1": datos = 0; return  context.getBean(OrderDataProcessImpl.class);
                                    case "2": datos = 0; break;
                                    case "3": datos = 0; return context.getBean(MenuProcessImpl.class);
                                    }

                        default: break;
                    }
                    if(datos <4){
                        showMenu(bot, chatId);
                    }
                } catch (NumberFormatException ex) {
                    showMenu(bot, chatId);
                }
                // continuar con el proceso seleccionado
            } else { // Si me enviaron algo diferente de un texto.
                showMenu(bot, chatId);
            }

        }

        return result;
    }

    public void showMenu(DeliveryLongPollingBot bot, long chatId){
        StringBuffer sb  = new StringBuffer();
        switch (datos){
            case 0: sb.append("Nombre: "); break;
            case 1: sb.append("Telefono: "); break;
            case 2: sb.append("NIT:"); break;
            case 3: sb.append("Nombre: ").append(UserSession.get(chatId,"nombre")).append("\n\r");
                    sb.append("Telefono: ").append(UserSession.get(chatId,"telefono")).append("\n\r");
                    sb.append("Nit: ").append(UserSession.get(chatId,"nit")).append("\n\r");
                    sb.append("1. Guardar: ").append("\n\r").append("2. Reintroducir Datos\n\r").append("3. Salir");

        }
        sendStringBuffer(bot,chatId,sb);
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
