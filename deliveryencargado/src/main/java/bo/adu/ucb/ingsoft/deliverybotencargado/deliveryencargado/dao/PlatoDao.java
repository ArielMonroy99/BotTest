package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dao;

import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto.PlatoDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface PlatoDao {

    @Select("select plato_id as id, nombre,precio,descripcion, imagen_url as img from plato where plato_id=2;")
    List<PlatoDto> findAllPlates();

    @Insert("INSERT INTO Plato (nombre, precio, descripcion, imagen_url, categoria_categoria_id, status)" +
            "VALUES (#{nombre}, #{precio}, #{descripcion}, #{img},#{categoria},1)")
    void guardarPlato(PlatoDto platoDto);
}
