package bo.edu.ucb.ingsoft.deliverybot.delivery.dao;

import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateInOrderDbDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateInOrderDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface PlateDao {

    @Select("select plato_id as id, nombre,precio,descripcion, imagen_url as img from plato where status = 1")
    List<PlateDto> findAllPlates();

    @Select("Select p.plato_id as id , pl.cantidad " +
            "    from plato p join platoenpedido pl on p.plato_id = pl.plato_plato_id where pl.pedido_pedido_id = #{pedido_id};")
    List<PlateInOrderDbDto> findPlatesInOrder(@Param("pedido_id")int pedido_id);

}
