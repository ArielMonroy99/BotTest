package bo.edu.ucb.ingsoft.deliverybot.delivery.dao;

import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.SucursalDto;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SucursalDao {
    @Select("Select sucursal_id,direccion,zona,latitud,longitud from sucursal where status = 1")
    List<SucursalDto> findAllBranch();
}
