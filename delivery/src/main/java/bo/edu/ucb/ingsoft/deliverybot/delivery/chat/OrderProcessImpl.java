package bo.edu.ucb.ingsoft.deliverybot.delivery.chat;

import org.telegram.telegrambots.meta.api.objects.Update;

public class OrderProcessImpl extends AbstractProcess{

    public OrderProcessImpl(){
        this.setName("Consultar Pedido actual");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }
    @Override
    public AbstractProcess handle(Update update, DeliveryLongPollingBot bot) {
        Long chatId = update.getMessage().getChatId();


        return null;
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
