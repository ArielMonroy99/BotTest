package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dao;

import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto.PedidoDto;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface PedidoDao {

    @Select("select pedido_id as id, estado as estado from pedido where pedido_id != 0;")
    List<PedidoDto> findAllPedidos();
}
