package bo.edu.ucb.ingsoft.rest.delivery.bl;

import bo.edu.ucb.ingsoft.rest.delivery.api.PlateApi;
import bo.edu.ucb.ingsoft.rest.delivery.dao.MenuDao;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.PlateApiDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuBl {
    private MenuDao menuDao;
    public Logger logger = LoggerFactory.getLogger(MenuBl.class);
    @Autowired
    public MenuBl(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    public List<PlateApiDto> allSoups(Integer pagesize, Integer pageNumber){
        if (pagesize == null){
            pagesize = 7;
        }if (pageNumber == null){
            pageNumber = 0;
        }
        List<PlateApiDto> menuSoup = menuDao.findAllPlatesSoup(pagesize,pageNumber);
        logger.debug(menuSoup.toString());
        return menuSoup;
    }

    public List<PlateApiDto> allMains(Integer pagesize, Integer pageNumber){
        if (pagesize == null){
            pagesize = 7;
        }if (pageNumber == null){
            pageNumber = 0;
        }
        List<PlateApiDto> menuMain = menuDao.findAllPlatesMain(pagesize,pageNumber);
        logger.debug(menuMain.toString());
        return menuMain;
    }

    public List<PlateApiDto> allDesserts(Integer pagesize, Integer pageNumber){
        if (pagesize == null){
            pagesize = 7;
        }if (pageNumber == null){
            pageNumber = 0;
        }
        List<PlateApiDto> menuDessert = menuDao.findAllPlatesDessert(pagesize,pageNumber);
        logger.debug(menuDessert.toString());
        return menuDessert;
    }
}
