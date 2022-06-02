package bo.edu.ucb.ingsoft.rest.delivery.dao;

import bo.edu.ucb.ingsoft.rest.delivery.dto.api.OrderApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.OrderDbDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.PlateInOrderDbDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDao {

    @Insert("insert into platoenpedido ( plato_plato_id, pedido_pedido_id, cantidad,notas, status) values (#{plateId},#{orderId},#{cantidad},#{nota},1) ")
    void savePlatesInOrder(PlateInOrderDbDto plate);

    @Insert("Insert into pedido (pedido_id, cliente_cliente_id, encargado_encargado_id,sucursal_sucursal_id,tarjeta_id,direccion_id," +
            " fecha, estado, metodo_de_pago, metodo_de_entrega, total, status)" +
            "values (#{pedidoId},#{clientId},#{encargadoId},#{sucursalId},#{tarjetaId},#{direccionId},#{fecha},#{estado}," +
            "#{metodoDePago},#{metodoDeEntrega},#{total},#{status})")
    void saveOrder (OrderDbDto orderDto);

    @Select("Select pedido_id, sucursal_sucursal_id as sucursal_id,fecha,estado,metodo_de_entrega,metodo_de_pago,total,propina,status,tx_id,tx_date,tx_host " +
            "from pedido where cliente_cliente_id = #{clientId} and status = 1 LIMIT #{pageSize} OFFSET #{offset}")
    List<OrderDbDto> orderList(@Param("clientId") Integer clientId, @Param("pageSize") Integer pageSize, @Param("offset") Integer offset);

    @Select("Select pedido_id, cliente_cliente_id as client_id,tarjeta_id,direccion_id, sucursal_sucursal_id as sucursal_id,fecha,estado,metodo_de_entrega,metodo_de_pago," +
            "total,propina,status,tx_id,tx_date,tx_host " +
            "from pedido where pedido_id = #{pedidoId} and status = 1")
    OrderDbDto findByOrderId(@Param("pedidoId") Integer orderId);

    @Select("Select plato_plato_id as plate_id , cantidad , status , " +
            "notas as nota , tx_id, tx_date,tx_host from platoenpedido where status = 1 and pedido_pedido_id = #{pedidoId}")
    List<PlateInOrderDbDto> findPlatesInOrder(@Param("pedidoId")int pedidoId);
}
