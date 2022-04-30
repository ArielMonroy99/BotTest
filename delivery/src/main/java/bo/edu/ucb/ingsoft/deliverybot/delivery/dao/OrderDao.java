package bo.edu.ucb.ingsoft.deliverybot.delivery.dao;

import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.OrderDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public interface OrderDao {

    @Select("Select fecha, estado, cliente_idcliente , encargado_ci,ubicacion,metododepago, delivery "+
            "from pedido " +
            "where cliente_idCliente  = #{id}")
    List<OrderDto> findLastOrder(@Param("id") String botCharId);

}
