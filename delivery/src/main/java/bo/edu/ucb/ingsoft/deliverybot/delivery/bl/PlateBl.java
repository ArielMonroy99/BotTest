package bo.edu.ucb.ingsoft.deliverybot.delivery.bl;

import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.OrderDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateDto;

import java.util.ArrayList;
import java.util.List;

public class PlateBl {

    public PlateBl(){

    }
    public List<PlateDto> TodayMenu(Long chatID){
        List<PlateDto> plates = new ArrayList<>();
        plates.add(new PlateDto(1,"Sopa lenteja", 500.0, "Es una sopa rica en muchas cosas"));
        plates.add(new PlateDto(2,"Lasaña de pollo", 45.5,"Es un plato muy famoso italiano"));
        plates.add(new PlateDto(3,"Fricase", 40.0, "Un plato muy bueno xd"));
        plates.add(new PlateDto(4,"Pollo dorado",60.0, "un plato muy delicioso"));

        return plates;
    }
}
