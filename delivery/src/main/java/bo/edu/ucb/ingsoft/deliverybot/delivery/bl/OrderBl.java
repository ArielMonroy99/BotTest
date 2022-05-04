package bo.edu.ucb.ingsoft.deliverybot.delivery.bl;

import bo.edu.ucb.ingsoft.deliverybot.delivery.dao.OrderDao;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.ClienteDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.OrderDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateInOrderDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderBl {
    private OrderDao orderDao;
    public static Logger logger = LoggerFactory.getLogger(OrderBl.class);
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

    public OrderDto createOrder(ClienteDto cliente, List<PlateInOrderDto> listadePlatos){
        OrderDto newOrder = new OrderDto();
        newOrder.setCliente(cliente);
        newOrder.setListaPlatos(listadePlatos);
        newOrder.getFecha(new Date());
        BigDecimal total;
        for(PlateInOrderDto plato:listadePlatos){
          //  total =

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
