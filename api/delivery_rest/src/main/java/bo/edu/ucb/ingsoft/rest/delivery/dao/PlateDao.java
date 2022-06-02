package bo.edu.ucb.ingsoft.rest.delivery.dao;

import bo.edu.ucb.ingsoft.rest.delivery.dto.api.PlateApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.ClientDbDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.PlateDbDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlateDao {

    @Select("Select plato_id ,nombre,precio,descripcion,imagen_url,categoria_categoria_id,status,tx_id," +
            "tx_date,tx_host from plato where plato_id = #{plateId}")
    PlateDbDto findPlateById(@Param("plateId")Integer plateId);

    @Insert("Insert into plato (nombre, precio, descripcion, imagen_url, categoria_categoria_id , status)" +
            "values (#{nombre},#{precio},#{descripcion},#{imagenUrl},#{categoriaCategoriaId},#{status});")
    void addPlate(PlateDbDto plate);

    @Update("Update plato SET nombre = #{nombre}, precio = #{precio}, descripcion = #{descripcion}, imagen_url = #{imagenUrl}, categoria_categoria_id =#{categoriaCategoriaId}"+
            "WHERE plato_id = #{platoId}")
    void updatePlate(PlateDbDto plate);

    @Delete("Update plato SET status =#{status}"+
            "WHERE plato_id = #{platoId}")
    void deletePlate(PlateDbDto plate);

    @Select("Select plato_id ,nombre,precio,descripcion,imagen_url,categoria_categoria_id,status,tx_id," +
            "tx_date,tx_host from plato WHERE categoria_categoria_id = #{categoriaCategoriaId} and status = 1")
    public List<PlateApiDto> findAllPlate(@Param("categoriaCategoriaId")Integer categoria_categoria_id);
}
