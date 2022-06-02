package bo.edu.ucb.ingsoft.rest.delivery.bl;

import bo.edu.ucb.ingsoft.rest.delivery.api.PlateApi;
import bo.edu.ucb.ingsoft.rest.delivery.dao.CategoryDao;
import bo.edu.ucb.ingsoft.rest.delivery.dao.MenuDao;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.CategoryApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.PlateApiDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryBl {
    private CategoryDao categoryDao;
    public Logger logger = LoggerFactory.getLogger(CategoryBl.class);

    @Autowired
    public CategoryBl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<CategoryApiDto> allCategories(){
        List<CategoryApiDto> categories = categoryDao.findAllCategories();
        logger.debug(categories.toString());
        System.out.println(categories);
        return categories;
    }
}
