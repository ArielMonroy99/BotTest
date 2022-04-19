package bo.edu.ucb.ingsoft.deliverybot.delivery.chat;

import org.telegram.telegrambots.meta.api.objects.Update;

public class OrderProcessImpl extends AbstractProcess{
    @Override
    public AbstractProcess handle(Update update, DeliveryLongPollingBot bot) {
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
