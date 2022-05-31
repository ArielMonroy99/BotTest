package bo.edu.ucb.ingsoft.rest.delivery.bl;

import bo.edu.ucb.ingsoft.rest.delivery.dao.OrderDao;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.OrderApiDto;
import org.springframework.stereotype.Service;

@Service
public class OrderBl {
    private OrderDao orderDao;

    public OrderBl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    public OrderApiDto createNewOrder(OrderApiDto order){

        return null;
    }
}
