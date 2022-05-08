package bo.edu.ucb.ingsoft.deliverybot.delivery.bl;

import bo.edu.ucb.ingsoft.deliverybot.delivery.dao.ClientDao;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dao.OrderDao;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dao.PlateDao;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.*;

import bo.edu.ucb.ingsoft.deliverybot.delivery.util.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.List;

@Service
public class OrderBl {
    private OrderDao orderDao;
    private ClientDao clientDao;
    private PlateDao plateDao;
    public static Logger logger = LoggerFactory.getLogger(OrderBl.class);
    @Autowired
    public OrderBl(OrderDao orderDao,ClientDao clientDao,PlateDao plateDao){
        this.orderDao = orderDao;
        this.clientDao = clientDao;
        this.plateDao = plateDao;
    }
    public OrderBl(){

    }

//    public OrderDto findLastOrder(Long chatId){
//
//      return orderDao.findLastOrder(chatId.toString());
//    }

//    public List<OrderDto> findLas10Orders(Long chatId){
//        orderDao = new OrderDao();
//        return orderDao.findLas10Orders(chatId);
//    }
    public OrderDto createOrder (ClientDto cliente, List<PlateInOrderDto> listadePlatos,Double latitud, Double longitud,int metodoDePago,int delivery){
        OrderDto newOrder = new OrderDto();
        newOrder.setCliente_id(cliente.getCliente_id());

        logger.info("se esta guardando {} y {}",cliente.getCliente_id(),cliente.getNombre());

        newOrder.setEncargado_id(1);//FIXME: agregar query para encontrar al encargado de turno

        newOrder.setId(orderDao.getNextOrderId());
        newOrder.setListaPlatos(listadePlatos);
        long fecha = new java.util.Date().getTime();
        newOrder.setFecha(new Timestamp(fecha));
        newOrder.setEstado(1);
        newOrder.setStatus(1);
        BigDecimal total = new BigDecimal(0);
        BigDecimal aux;
        for(PlateInOrderDto plato:listadePlatos){
            aux = plato.getPlato().getPrecio();
            aux = aux.multiply(new BigDecimal(plato.getCantidad()));
            total = total.add(aux);
        }
        total = total.add(BigDecimal.valueOf(10.00));
        logger.info("el total es: {}",total);
        newOrder.setMetodoDePago(metodoDePago);
        newOrder.setDelivery(delivery);
        if(delivery ==2){
            newOrder.setLatitud(latitud);
            newOrder.setLongitud(longitud);
        }
        else{
            newOrder.setLatitud(0.0);
            newOrder.setLongitud(0.0);
        }
        newOrder.setTotal(total);
        return newOrder;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public OrderDto saveOrder(OrderDto order ,ClientDto cliente){

       // ClientDto clientDto = clientDao.getClientData(cliente.getChat_id());
        if((boolean) UserSession.get(cliente.getChat_id(),"nuevo_cliente")){
            clientDao.saveClient(cliente);
        }

        logger.info("se esta guardando {} y {}",cliente.getCliente_id(),cliente.getNombre());

        orderDao.saveOrder(order);
        for(PlateInOrderDto plate: order.getListaPlatos()){
            logger.info("Se esta guardando: {} , en pedido {}", plate.getPlato().getNombre(),order.getId());
            orderDao.savePlatesInOrder(plate.getPlato().getId(),order.getId(),plate.getCantidad());
       }
       UserSession.put(cliente.getChat_id(),"Lista",null);

        return order;
    }
    public List<PlateInOrderDto> addPlateToList (List<PlateInOrderDto> list,PlateInOrderDto newPlate){
        boolean isRepeated = false;
        if(list != null && newPlate !=null ){
            for(PlateInOrderDto plate : list){
                if(plate.getPlato().getId() == newPlate.getPlato().getId()){
                    plate.setCantidad(plate.getCantidad() + newPlate.getCantidad());
                    isRepeated = true;
                }
            }
            if(!isRepeated){
                list.add(newPlate);
            }
        }else {
            logger.info("No existe la lista");
        }
        return list;
    }
    public OrderDto LastOrder(long chatId){
        OrderDto lastOrder  = orderDao.Lastorder(chatId);
        List<PlateDto> platos = plateDao.findAllPlates();
        List<PlateInOrderDbDto> platesInOrder = plateDao.findPlatesInOrder(lastOrder.getId());
        List<PlateInOrderDto> plates = new ArrayList<>();
        for(PlateInOrderDbDto p : platesInOrder){
            for(PlateDto pl : platos){
                if(p.getPlato_id() == pl.getId()){
                    plates.add(new PlateInOrderDto(pl,p.getCantidad()));
                }
            }
        }
        lastOrder.setListaPlatos(plates);


        return lastOrder;
    }

}
