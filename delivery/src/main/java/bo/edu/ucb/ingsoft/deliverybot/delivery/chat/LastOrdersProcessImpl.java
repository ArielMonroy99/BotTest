package bo.edu.ucb.ingsoft.deliverybot.delivery.chat;

import bo.edu.ucb.ingsoft.deliverybot.delivery.bl.OrderBl;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.OrderDto;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.List;

public class LastOrdersProcessImpl extends AbstractProcess{

    public LastOrdersProcessImpl() {
        this.setName("Lista de Pedidos Anteriores");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    @Override
    public AbstractProcess handle(Update update, DeliveryLongPollingBot bot) {
        Long chatId = update.getMessage().getChatId();
        int c = 1;

        OrderBl orderBl = new OrderBl();
        List<OrderDto> lastOrders = orderBl.findLas10Orders(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("<----- Pedidos ------>\n");
        for(OrderDto order: lastOrders){

            sb.append("Pedido: ").append(c).append("\n");
            sb.append(order.toString2()).append("\n\r");
            sb.append("----------------------------------\n");
            c++;
        }
        sendStringBuffer(bot,chatId,sb);
        return new MenuOrderProcessImpl();
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
