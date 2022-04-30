package bo.edu.ucb.ingsoft.deliverybot.delivery.bl;

import bo.edu.ucb.ingsoft.deliverybot.delivery.dao.OrderDao;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.OrderDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateInOrderDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderBl {
    private OrderDao orderDao;
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
}
