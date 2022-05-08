package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.chat;

import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.bl.EncargadoBl;
import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dao.EncargadoDao;
import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto.EncargadoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;

@Service
public class MenuProcessImpl extends AbstractProcess {
    int cen=0;
    private EncargadoBl encargadoBl;
    @Autowired
    public MenuProcessImpl(EncargadoBl encargadoBl) {
        this.encargadoBl = encargadoBl;
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
                if (cen == 0){
                    try {
                        int opcion = Integer.parseInt(text);
                        StringBuffer sb = new StringBuffer();
                        sb.append("ChatID:  "+chatId+"\n\r");
                        switch (opcion){
                            case 1 :
                                sendStringBuffer(bot, chatId, sb);
                                result = context.getBean(MenuProcessImpl.class);
                                break;
                            case 2 :
                                EncargadoDto encargadoDto = encargadoBl.getEncargadoData(chatId);
                                if (encargadoDto != null){
                                    cen=1;
                                    showMainMenu(bot, chatId);
                                }
                                else {
                                    showMainMenu(bot, chatId);
                                }
                                break;
//                        case 3: result = new MenuOrderProcessImpl(); break;
                            default: showMainMenu(bot, chatId); break;
                        }
                    } catch (NumberFormatException ex) {
                        showMainMenu(bot, chatId);
                    }
                }
                else {
                    EncargadoDto encargadoDto = encargadoBl.getEncargadoData(chatId);
                    if (text.equals(encargadoDto.getPassword())){
                        result = context.getBean(MenuEncargadoProcessImpl.class);
                    }
                    else {
                        StringBuffer sb = new StringBuffer();
                        sb.append("contraseña incorrecta\r\n");
                        sendStringBuffer(bot, chatId, sb);
                        showMainMenu(bot, chatId);
                    }
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
        if (cen == 0){
            sb.append("Bot DeliveryEncargado\r\n");
            sb.append("1. ChadID\r\n");
            sb.append("2. Login \r\n");
            sb.append("Elija una opción:\r\n");
        }
        else {
            sb.append("Ingrese su contraseña:\r\n");
        }
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
