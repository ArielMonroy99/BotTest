package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dao;

import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto.EncargadoDto;
import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto.PedidoDto;
import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto.PlatoDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface EncargadoDao {
    @Select("select password as password from encargado where status = 1 and chat_id = #{chat_id}")
    EncargadoDto getEncargadoData(@Param("chat_id")long chat_id);
}
