package bo.edu.ucb.ingsoft.rest.delivery.dao;

import bo.edu.ucb.ingsoft.rest.delivery.dto.api.CategoryApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.PlateApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.ClientDbDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.PlateDbDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CategoryDao {
    @Select("select categoria_id as categoryId, nombre, image_url from categoria")
    List<CategoryApiDto> findAllCategories();
}
