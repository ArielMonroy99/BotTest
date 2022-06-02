package bo.edu.ucb.ingsoft.rest.delivery.dao;

import bo.edu.ucb.ingsoft.rest.delivery.dto.db.CardDbDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.OrderDbDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardDao {
    @Select("Select id as cardId, nro , venc as vencimiento,nombre,status,tx_id,tx_host,tx_date from tarjeta where id = #{cardId}")
    CardDbDto getCardById(@Param("cardId") Integer cardId);

    @Insert("insert into tarjeta (id, nro, venc, nombre, cliente_cliente_id, status, tx_id, tx_host, tx_date)" +
            "values (#{tarjetaId},#{nro},#{vencimiento},#{clientId},#{status},#{txId},#{txHost},#{txDate};")
    void createNewCard(CardDbDto cardDbDto , @Param("clientId") Integer clientId);

    @Select("Select pedido_id, sucursal_sucursal_id,fecha,estado,metodo_de_entrega,metodo_de_pago from pedido where cliente_cliente_id = #{clientId} LIMIT #{pageSize} OFFSET #{offset}")
    List<OrderDbDto> orderList(@Param("clientId") Integer clientId,@Param("pageSize") Integer pageSize,@Param("offset") Integer offset);

    @Select("Select pedido_id, sucursal_sucursal_id,fecha,estado,metodo_de_entrega,metodo_de_pago from pedido where cliente_cliente_id = #{clientId} LIMIT #{pageSize} OFFSET #{offset}")
    OrderDbDto getOrderById(@Param("clientId") Integer clientId,@Param("pageSize") Integer pageSize,@Param("offset") Integer offset);
}
