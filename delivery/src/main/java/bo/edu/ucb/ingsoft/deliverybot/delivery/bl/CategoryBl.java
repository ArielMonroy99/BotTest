package bo.edu.ucb.ingsoft.deliverybot.delivery.bl;

import bo.edu.ucb.ingsoft.deliverybot.delivery.dao.CategoryDao;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dao.PlateDao;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryBl {
    private static CategoryDao categoryDao;

    @Autowired
    public CategoryBl(CategoryDao categoryDao){
        this.categoryDao = categoryDao;
    }
    public static List<PlateDto> CategorySoup(){
        return categoryDao.findAllPlatesSoup();
    }

    public static List<PlateDto> CategoryMain(){
        return categoryDao.findAllPlatesMain();
    }

    public static List<PlateDto> CategoryDessert(){
        return categoryDao.findAllPlatesDessert();
    }
}
