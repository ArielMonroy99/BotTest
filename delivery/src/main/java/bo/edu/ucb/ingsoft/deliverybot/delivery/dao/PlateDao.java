package bo.edu.ucb.ingsoft.deliverybot.delivery.dao;

import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateDto;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface PlateDao {

    @Select("select plato_id as id, nombre,precio,descripcion, imagen_url as img from plato")
    List<PlateDto> findAllPlates();


}
