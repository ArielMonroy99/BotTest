package bo.edu.ucb.ingsoft.deliverybot.delivery;

import bo.edu.ucb.ingsoft.deliverybot.delivery.bl.ClientBl;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dao.ClientDao;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dao.OrderDao;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dao.PlateDao;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisTest {
    private PlateDao plateDao;
    private OrderDao orderDao;
    @Autowired
    public MyBatisTest(PlateDao plateDao, OrderDao orderDao) {
        this.plateDao = plateDao;
        this.orderDao = orderDao;
    }

    @Test
    public void testSelectAllPlates(){
        long chatId = Long.valueOf("5230435511");
        OrderDto order = orderDao.Lastorder(chatId);
        System.out.println("id: "+order.getId()+"\nfecha:"+order.getFecha()+"\ntotal:"+order.getTotal()
                +"\nLatitud: "+order.getLatitud()+"\nLongitud: "+order.getLongitud());
    }
}
