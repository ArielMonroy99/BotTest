package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.chat;

import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.bl.PlatoBl;
import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto.PlatoDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AgregarPlatoProcessImpl extends AbstractProcess{
    private PlatoBl platoBl;
    public int cont = 1;
    PlatoDto  aux = new PlatoDto();
    int cen = 0,cen2=0,aux2,aux3;
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
                sendStringBuffer(bot, chatId, sb);
                break;
            case 2:
                sb.append("Precio: \r\n");
                sendStringBuffer(bot, chatId, sb);
                break;
            case 3:
                sb.append("Descripcion: \r\n");
                sendStringBuffer(bot, chatId, sb);
                break;
            case 4:
                sb.append("Imagen(URL): \r\n");
                sendStringBuffer(bot, chatId, sb);
                break;
            case 5:
                sb.append("Categoria: \r\n");
                sb.append("1. Sopa \r\n");
                sb.append("2 Plato Principal \r\n");
                sb.append("3 Postre \r\n");
                sendStringBuffer(bot, chatId, sb);
                break;
            case 6:
                if (cen2 == 0){
                    cen2=1;
                    sb.append("2. Nombre: "+ aux.getNombre()).append("\n\r");
                    sb.append("3. Precio: "+aux.getPrecio() + " Bs").append("\n\r");
                    sb.append("4. Descripcion: "+aux.getDescripcion()).append("\n\r");
                    sb.append("5. Imagen(URL): "+aux.getImg()).append("\n\r");
                    sb.append("6. Categoria: "+aux.getCategoria()).append("\n\r");
                    sb.append("\n");
                    sb.append("1.Guardar:  \r\n");
                    sb.append("0.Cancelar:  \r\n");
                    sendPhotoB(bot,chatId,aux.getImg(), String.valueOf(sb));
                    sb.setLength(0);
                }
                else {
                    cen2=0;
                    aux2=aux3;
                    switch (aux3){
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
                break;
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
                                aux.setPrecio(new BigDecimal(text));
                                break;
                            case 3:
                                aux.setDescripcion(text);
                                break;
                            case 4:
                                aux.setImg(text);
                                break;
                            case 5:
                                if (Integer.parseInt(text) >= 1 && Integer.parseInt(text)<= 3){
                                    aux.setCategoria(Integer.parseInt(text));
                                }
                                else {
                                    sb.append("Categoría incorrecta  \r\n");
                                    sb.append("Por favor vuelva a ingresar: \r\n");
                                    sendStringBuffer(bot, chatId, sb);
                                    cont--;
                                }
                                break;
                            case 6:
                                if (cen2==1){
                                    int opcion = Integer.parseInt(text);
                                    aux3 = opcion;
                                }
                                if (cen2==0){
                                    switch (aux2){
                                        case 0:
                                            result = context.getBean(MenuEncargadoProcessImpl.class);
                                            cen = 1;
                                            this.setStatus("STARTED");
                                            break;
                                        case 1:
                                            platoBl.guardarPlato(aux);
                                            sb.append("El plato se agrego  \r\n");
                                            sendStringBuffer(bot, chatId, sb);
                                            result = context.getBean(MenuEncargadoProcessImpl.class);
                                            cen = 1;
                                            this.setStatus("STARTED");
                                            break;
                                        case 2:
                                            aux.setNombre(text);

                                            break;
                                        case 3:
                                            aux.setPrecio(new BigDecimal(text));

                                            break;
                                        case 4:
                                            aux.setDescripcion(text);

                                            break;
                                        case 5:
                                            aux.setImg(text);

                                            break;
                                        case 6:
                                            if (Integer.parseInt(text) >= 1 && Integer.parseInt(text)<= 3){
                                                aux.setCategoria(Integer.parseInt(text));

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
                                break;
                        }
                        if (cont != 6){
                            cont++;
                        }
                        if (cen==0){
                            showMenuRestaurant(bot,chatId);
                        }

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
