package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.chat;

import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.bl.PedidoBl;
import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto.PedidoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;


@Service
public class PedidoProcessImpl extends AbstractProcess{
    private PedidoBl pedidoBl;

    @Autowired
    PedidoProcessImpl(PedidoBl pedidoBl){
        this.pedidoBl = pedidoBl;
        this.setName("Pedidos");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
//      this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    private void showMenuRestaurant(DeliveryLongPollingBot bot, Long chatId){

        List<PedidoDto> pedidos = pedidoBl.Pedidos();
        StringBuffer sb = new StringBuffer();
        sb.append("Lista de pedidos\r\n");
        sendStringBuffer(bot,chatId,sb);
        sb.setLength(0);
        pedidos.forEach(pedido->{

            sb.append("ID:  "+pedido.getId()).append("\n\r");
            sb.append("Estado: "+pedido.getEstado()).append("\n\r");

            sendStringBuffer(bot, chatId, sb);
            sb.append("\n");
            sb.setLength(0);
        });
        sb.append("Selecione un pedido ").append("\n\r");
        sb.append("0: Salir").append("\n\r");
        sendStringBuffer(bot,chatId,sb);
        this.setStatus("AWAITING_USER_RESPONSE");
    }

    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, DeliveryLongPollingBot bot) {
        AbstractProcess result = this;
        Long chatId = update.getMessage().getChatId();


        if (this.getStatus().equals("STARTED")) {

            showMenuRestaurant(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por un numero 1 o 2
            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasda
                try {
                    int opcion = Integer.parseInt(text);
                    List<PedidoDto> pedidos = pedidoBl.Pedidos();
                    if (opcion == 0){
                        result = context.getBean(MenuProcessImpl.class);
                    }else{
                        result = new EstadoPedidoProcessImpl(pedidos.get(opcion-1), pedidoBl);
                    }
                } catch (NumberFormatException ex) {
                    showMenuRestaurant(bot, chatId);
                }
                // continuar con el proceso seleccionado
            } else { // Si me enviaron algo diferente de un texto.
                showMenuRestaurant(bot, chatId);
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
