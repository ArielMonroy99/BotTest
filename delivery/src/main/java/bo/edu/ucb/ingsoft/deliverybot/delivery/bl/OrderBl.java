package bo.edu.ucb.ingsoft.deliverybot.delivery.bl;

import bo.edu.ucb.ingsoft.deliverybot.delivery.dao.ClientDao;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dao.OrderDao;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.ClientDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.OrderDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateInOrderDto;

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
    public static Logger logger = LoggerFactory.getLogger(OrderBl.class);
    @Autowired
    public OrderBl(OrderDao orderDao,ClientDao clientDao){
        this.orderDao = orderDao;
        this.clientDao = clientDao;
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
    @Transactional(propagation = Propagation.REQUIRED)
    public OrderDto createOrder(ClientDto cliente, List<PlateInOrderDto> listadePlatos,Double latitud, Double longitud,int metodoDePago,int delivery){
        OrderDto newOrder = new OrderDto();
        newOrder.setCliente_id(cliente.getCliente_id());

        clientDao.saveClient(cliente);
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

        logger.info("Se esta guardando: {}", newOrder);
        orderDao.saveOrder(newOrder);
        for(PlateInOrderDto plate: listadePlatos){
            logger.info("Se esta guardando: {} , en pedido {}", plate.getPlato().getNombre(),newOrder.getId());
            orderDao.savePlatesInOrder(plate.getPlato().getId(),newOrder.getId(),plate.getCantidad());
       }
        return newOrder;
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


}
