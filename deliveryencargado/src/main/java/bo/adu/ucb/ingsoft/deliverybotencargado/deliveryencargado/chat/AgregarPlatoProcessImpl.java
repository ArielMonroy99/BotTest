package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.chat;

import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.bl.PlatoBl;
import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto.PlatoDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
public class AgregarPlatoProcessImpl extends AbstractProcess{
    private PlatoBl platoBl;
    public int cont = 1;
    PlatoDto  aux = new PlatoDto();
    int cen = 0;
    @Autowired
    AgregarPlatoProcessImpl(PlatoBl platoBl){
        this.platoBl = platoBl;
        this.setName("AgregarPlatos");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
//      this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    private void showMenuRestaurant(DeliveryLongPollingBot bot, Long chatId){

        StringBuffer sb = new StringBuffer();

        switch (cont){
            case 1:
                sb.append("Nombre: \r\n");
                break;
            case 2:
                sb.append("Precio: \r\n");
                break;
            case 3:
                sb.append("Descripcion: \r\n");
                break;
            case 4:
                sb.append("Imagen(URL): \r\n");
                break;
            case 5:
                sb.append("Categoria: \r\n");
                break;
            case 6:
                sb.append("Datos:  "+aux+"\r\n");
                sb.append("1.Cancelar:  \r\n");
                sb.append("2.Guardar:  \r\n");
                break;
        }

        sendStringBuffer(bot, chatId, sb);
        this.setStatus("AWAITING_USER_RESPONSE");
    }

    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, DeliveryLongPollingBot bot) {
        AbstractProcess result = this;
        Long chatId = update.getMessage().getChatId();
        StringBuffer sb = new StringBuffer();

        if (this.getStatus().equals("STARTED")) {

            showMenuRestaurant(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por un numero 1 o 2
            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasda
//                try {
//                    int opcion = Integer.parseInt(text);
                    if (text.equals("0")){
                        result = new MenuProcessImpl();
                    }
                    else{
                        //opcion = 1;
                        switch (cont){
                            case 1:
                                aux.setNombre(text);
                                break;
                            case 2:
                                aux.setPrecio(Double.parseDouble(text));
                                break;
                            case 3:
                                aux.setDescripcion(text);
                                break;
                            case 4:
                                aux.setImg(text);
                                break;
                            case 5:
                                aux.setCategoria(Integer.parseInt(text));
                                break;
                            case 6:
                                if (Integer.parseInt(text)==1){
                                    result = new MenuEncargadoProcessImpl();
                                    cen = 1;
                                    sb.append("El plato no se agrego  \r\n");
                                }else if(Integer.parseInt(text)==2){
                                    platoBl.guardarPlato(aux);
                                    result = new MenuEncargadoProcessImpl();
                                    cen = 1;
                                    sb.append("El plato se agrego  \r\n");
                                    }
                                else {
                                    showMenuRestaurant(bot,chatId);
                                }
                                break;
                        }
                        if (cen==0){
                            cont++;
                            showMenuRestaurant(bot,chatId);
                        }
                        sendStringBuffer(bot, chatId, sb);
                    }

//                } catch (NumberFormatException ex) {
//                    showMenuRestaurant(bot, chatId);
//                }
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
