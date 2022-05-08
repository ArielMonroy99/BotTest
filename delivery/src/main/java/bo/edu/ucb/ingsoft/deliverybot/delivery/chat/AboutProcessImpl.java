package bo.edu.ucb.ingsoft.deliverybot.delivery.chat;

import bo.edu.ucb.ingsoft.deliverybot.delivery.bl.SucursalBl;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.SucursalDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;
@Service
public class AboutProcessImpl extends AbstractProcess{
    private SucursalBl sucursalBl;
    public Logger logger = LoggerFactory.getLogger(AboutProcessImpl.class);
    public AboutProcessImpl(SucursalBl sucursalBl){
        this.sucursalBl = sucursalBl;
        this.setName("Informacion");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setStatus("STARTED");
    }
    private void showMainMenu(DeliveryLongPollingBot bot, Long chatId) {
        StringBuffer sb = new StringBuffer();
        sb.append("Encuentranos en: \n");
        List<SucursalDto> list = sucursalBl.findAllBranches();
        sendStringBuffer(bot,chatId,sb);
        for(SucursalDto sucursal : list){
            sb.setLength(0);
            sb.append(sucursal);
            sendStringBuffer(bot,chatId,sb);
            sendLocation(bot,chatId,sucursal.getLatitud(),sucursal.getLongitud());
            sb.setLength(0);
        }
        sb.append("1. Volver al Menu Principal\r\n");
        sendStringBuffer(bot, chatId, sb);

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
                        case 1 : result = context.getBean(MenuProcessImpl.class);
                            break;
                        default: showMainMenu(bot, chatId);
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
