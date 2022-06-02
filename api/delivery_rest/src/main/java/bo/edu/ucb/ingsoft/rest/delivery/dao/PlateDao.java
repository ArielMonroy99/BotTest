package bo.edu.ucb.ingsoft.rest.delivery.dao;

import bo.edu.ucb.ingsoft.rest.delivery.dto.db.ClientDbDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.PlateDbDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

@Service
public interface PlateDao {

    @Select("Select plato_id ,nombre,precio,descripcion,imagen_url,categoria_categoria_id,status,tx_id," +
            "tx_date,tx_host from plato where plato_id = #{plateId}")
    PlateDbDto findPlateById(@Param("plateId")Integer plateId);

    @Insert("Insert into plato (plato_id, nombre, precio, descripcion, imagen_url, categoria_categoria_id , status)" +
            "values ( #{plato_id},#{nombre},#{precio},#{descripcion},#{imagen_url},#{categoria_categoria_id},#{status});")
    void addPlate(PlateDbDto plate);

    @Update("Update plato SET nombre = #{nombre}, precio = #{precio}, descripcion = #{descripcion}, imagen_url = #{imagen_url}, categoria_categoria_id =#{categoria_categoria_id}"+
            "WHERE plato_id = #{plato_id}")
    void updatePlate(PlateDbDto plate);

    @Delete("Update plato SET status =#{status}"+
            "WHERE plato_id = #{plato_id}")
    void deletePlate(PlateDbDto plate);

}
