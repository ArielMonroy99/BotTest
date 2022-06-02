package bo.edu.ucb.ingsoft.rest.delivery.dao;

import bo.edu.ucb.ingsoft.rest.delivery.dto.api.PlateApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.ClientDbDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.PlateDbDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface MenuDao {

    @Select("select plato_id as platoId, nombre,precio,descripcion, imagen_url , categoria_categoria_id  from plato where categoria_categoria_id = 1 LIMIT #{limit} OFFSET #{offset}")
    List<PlateApiDto> findAllPlatesSoup(@Param("limit")Integer limit, @Param("offset")Integer offset);

    @Select("select plato_id as platoId, nombre,precio,descripcion, imagen_url  , categoria_categoria_id   from plato where categoria_categoria_id = 2 LIMIT #{limit} OFFSET #{offset}")
    List<PlateApiDto> findAllPlatesMain(@Param("limit")Integer limit, @Param("offset")Integer offset);

    @Select("select plato_id as platoId, nombre,precio,descripcion, imagen_url , categoria_categoria_id   from plato where categoria_categoria_id = 3 LIMIT #{limit} OFFSET #{offset}")
    List<PlateApiDto> findAllPlatesDessert(@Param("limit")Integer limit, @Param("offset")Integer offset);

}
