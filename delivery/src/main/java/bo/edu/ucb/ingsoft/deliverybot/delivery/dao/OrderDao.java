package bo.edu.ucb.ingsoft.deliverybot.delivery.dao;

import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.OrderDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public interface OrderDao {

//    @Select("SELECT p.pedido_id, p.cliente_cliente_id, p.fecha, p.total from pedido p join cliente c2\n" +
//            "    on p.cliente_cliente_id = c2.cliente_id where chat_id = {chatId}" )
//    List<OrderDto> findLastsOrders(@Param("chatId")long ChatId);
    @Select("SELECT o.pedido_id as id, o.estado,o.fecha,o.total, o.longitud , o.latitud , o.delivery from pedido o join cliente c on o.cliente_cliente_id = c.cliente_id"+
            " where c.chat_id = #{chatId} and o.estado != 3 and o.estado != 5 ORDER BY o.fecha DESC LIMIT 1")
    OrderDto Lastorder(@Param("chatId")long chatId);

    @Select("Select nextval('pedido_cliente_cliente_id_seq')")
    int getNextOrderId();

    @Insert("Insert into pedido (pedido_id, cliente_cliente_id, encargado_encargado_id, fecha, estado, longitud, latitud, metodo_de_pago, delivery, total, status)" +
            "values (#{id},#{cliente_id},#{encargado_id},#{fecha},#{estado},#{longitud},#{latitud},#{metodoDePago},#{delivery},#{total},#{status})")
    void saveOrder (OrderDto orderDto);

    @Insert("insert into platoenpedido ( plato_plato_id, pedido_pedido_id, cantidad, status) values (#{platoId},#{orderId},#{cantidad},1) ")
    void savePlatesInOrder(@Param("platoId") int platoId,@Param("orderId")int orderId,@Param("cantidad") int cantidad);
}
