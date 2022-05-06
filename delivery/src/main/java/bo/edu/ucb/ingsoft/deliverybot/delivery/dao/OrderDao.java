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

    @Select("Select fecha, estado, cliente_idcliente , encargado_ci,ubicacion,metododepago, delivery "+
            "from pedido " +
            "where cliente_cliente  = #{id} and status = 1")
    List<OrderDto> findLastOrder(@Param("id") String botCharId);

    @Select("Select nextval('pedido_cliente_cliente_id_seq')")
    int getNextOrderId();

    @Insert("Insert into pedido (pedido_id, cliente_cliente_id, encargado_encargado_id, fecha, estado, longitud, latitud, metodo_de_pago, delivery, total, status)" +
            "values (#{id},#{cliente_id},#{encargado_id},#{fecha},#{estado},#{longitud},#{latitud},#{metodoDePago},#{delivery},#{total},#{status})")
    void saveOrder (OrderDto orderDto);

    @Insert("insert into platoenpedido ( plato_plato_id, pedido_pedido_id, cantidad, status) values (#{platoId},#{orderId},#{cantidad},1) ")
    void savePlatesInOrder(@Param("platoId") int platoId,@Param("orderId")int orderId,@Param("cantidad") int cantidad);
}
