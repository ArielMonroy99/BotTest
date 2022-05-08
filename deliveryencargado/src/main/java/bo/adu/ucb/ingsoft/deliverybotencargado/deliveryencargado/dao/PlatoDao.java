package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dao;

import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto.PlatoDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface PlatoDao {

    @Select("select plato_id as id, nombre,precio,descripcion, imagen_url as img , categoria_categoria_id as categoria , status from plato where status = 1 and categoria_categoria_id =  1")
    List<PlatoDto> findAllPlates();

    @Select("select plato_id as id, nombre,precio,descripcion, imagen_url as img , categoria_categoria_id as categoria , status from plato where status = 1 and categoria_categoria_id =  1")
    List<PlatoDto> findAllSopa();
    @Select("select plato_id as id, nombre,precio,descripcion, imagen_url as img , categoria_categoria_id as categoria , status from plato where status = 1 and categoria_categoria_id =  2")
    List<PlatoDto> findAllPrincipal();
    @Select("select plato_id as id, nombre,precio,descripcion, imagen_url as img , categoria_categoria_id as categoria , status from plato where status = 1 and categoria_categoria_id =  3")
    List<PlatoDto> findAllPostre();

    @Insert("INSERT INTO Plato (nombre, precio, descripcion, imagen_url, categoria_categoria_id, status)" +
            "VALUES (#{nombre}, #{precio}, #{descripcion}, #{img},#{categoria},1)")
    void guardarPlato(PlatoDto platoDto);

    @Update("UPDATE Plato SET nombre=#{nombre}, precio=#{precio}, descripcion=#{descripcion}, imagen_url=#{img}, categoria_categoria_id=#{categoria}, status=1"+
            "WHERE plato_id=#{id}")
    void actualizarPlato(PlatoDto platoDto);

    @Update("UPDATE Plato SET status=0"+
            "WHERE plato_id=#{id}")
    void eliminarPlato(PlatoDto platoDto);
}
