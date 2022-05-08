package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.chat;

import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.bl.PlatoBl;
import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto.PlatoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.xml.transform.Result;
import java.math.BigDecimal;
import java.util.List;

@Service
public class EditarProcessImpl extends AbstractProcess{
    private PlatoBl platoBl;
    private PlatoDto platoDto;
    PlatoDto  aux = new PlatoDto();
    int cen = 0 , cen2=0;
    int cont,aux2;

    @Autowired
    EditarProcessImpl(PlatoDto platoDto, PlatoBl platoBl){
        this.platoBl = platoBl;
        this.setName("EditarPlatos");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
//      this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
        this.platoDto = platoDto;
    }

    private void showMenuRestaurant(DeliveryLongPollingBot bot, Long chatId){

        StringBuffer sb = new StringBuffer();
        if (cen2==0){
            cen2=1;
            sb.append("Seleccione el atributo que desea modificar:\r\n");
            sb.append("2. Nombre: "+ platoDto.getNombre()).append("\n\r");
            sb.append("3. Precio: "+platoDto.getPrecio() + " Bs").append("\n\r");
            sb.append("4. Descripcion: "+platoDto.getDescripcion()).append("\n\r");
            sb.append("5. Imagen(URL): "+platoDto.getImg()).append("\n\r");
            sb.append("6. Categoria: "+platoDto.getCategoria()).append("\n\r");
            sb.append("\n");
            sb.append("0. atras").append("\n\r");
            sb.append("1. guardar").append("\n\r");
            sendPhotoB(bot,chatId,platoDto.getImg(), String.valueOf(sb));
        }
        else {
            cen2=0;
            aux2=cont;
            switch (cont){
                case 2:
                    sb.append("Nuevo Nombre: \r\n");
                    break;
                case 3:
                    sb.append("Nuevo Precio: \r\n");
                    break;
                case 4:
                    sb.append("Nueva Descripcion: \r\n");
                    break;
                case 5:
                    sb.append("Nueva Imagen(URL): \r\n");
                    break;
                case 6:
                    sb.append("Nueva Categoria: \r\n");
                    sb.append("1. Sopa \r\n");
                    sb.append("2 Plato Principal \r\n");
                    sb.append("3 Postre \r\n");
                    break;
            }

            sendStringBuffer(bot, chatId, sb);

        }
        sb.setLength(0);
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

                    if (cen2==1){
                        int opcion = Integer.parseInt(text);
                        cont = opcion;
                        if(opcion == 1){
                            platoBl.actualizarPlato(platoDto);
                            sb.append("El plato se guardo  \r\n");
                            sendStringBuffer(bot, chatId, sb);
                            result = new MenuEncargadoProcessImpl();

                            cen = 1;

                        }
                        else if (opcion == 0){
                            result = new MenuEncargadoProcessImpl();
                            cen = 1;
                        }
                    }

                    if (cen2==0){
                        switch (aux2){
                            case 2:
                                aux.setNombre(text);
                                platoDto.setNombre(aux.getNombre());
                                break;
                            case 3:
                                aux.setPrecio(new BigDecimal(text));
                                platoDto.setPrecio(aux.getPrecio());
                                break;
                            case 4:
                                aux.setDescripcion(text);
                                platoDto.setDescripcion(aux.getDescripcion());
                                break;
                            case 5:
                                aux.setImg(text);
                                platoDto.setImg(aux.getImg());
                                break;
                            case 6:
                                if (Integer.parseInt(text) >= 1 && Integer.parseInt(text)<= 3){
                                    aux.setCategoria(Integer.parseInt(text));
                                    platoDto.setCategoria(aux.getCategoria());
                                }
                                else {
                                    sb.append("Categoría incorrecta  \r\n");
                                    sb.append("Por favor vuelva a ingresar: \r\n");
                                    sendStringBuffer(bot, chatId, sb);
                                    cen2=1;
                                }
                                break;

                        }
                    }

                if (cen==0){
                    showMenuRestaurant(bot,chatId);
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
