package bo.edu.ucb.ingsoft.deliverybot.delivery.bl;

import bo.edu.ucb.ingsoft.deliverybot.delivery.dao.PlateDao;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.OrderDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateDto;

import java.util.ArrayList;
import java.util.List;

public class PlateBl {
    private PlateDao plateDao;
    public PlateBl(){

    }
    public List<PlateDto> TodayMenu(Long chatID){

        plateDao = new PlateDao();
        return plateDao.TodayMenu(chatID);
    }

}
