package bo.edu.ucb.ingsoft.deliverybot.delivery.dao;

import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateDto;

import java.util.ArrayList;
import java.util.List;

public class PlateDao {

    public List<PlateDto> TodayMenu(Long chatID){
        List<PlateDto> plates = new ArrayList<>();
        plates.add(new PlateDto(1,"Sopa lenteja", 500.0, "Es una sopa rica en muchas cosas","https://d1kxxrc2vqy8oa.cloudfront.net/wp-content/uploads/2019/02/12120103/RFB-0102-5-sopadelentejas.jpg"));
        plates.add(new PlateDto(2,"Lasaña de pollo", 45.5,"Es un plato muy famoso italiano","https://dam.cocinafacil.com.mx/wp-content/uploads/2020/12/lasa%C3%B1a-receta.jpg"));
        plates.add(new PlateDto(3,"Fricase", 40.0, "Un plato muy bueno xd","https://1.bp.blogspot.com/-LeU4P_It0v4/XrcYrGhe-XI/AAAAAAAAcL8/1QmXKUdyBG8kpZCaQI_qAWYY28RcATsawCLcBGAsYHQ/s1600/FRICASE%2BDE%2BCHANCHO%2B1.jpg"));
        plates.add(new PlateDto(4,"Pollo dorado",60.0, "un plato muy delicioso","https://t2.rg.ltmcdn.com/es/posts/5/1/6/pollo_frito_con_mayonesa_60615_600.jpg"));

        return plates;
    }
}
