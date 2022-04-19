package bo.edu.ucb.ingsoft.deliverybot.delivery.bl;

import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.OrderDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateDto;

import java.util.ArrayList;
import java.util.List;

public class OrderBl {
    public OrderBl(){

    }
    public OrderDto findLastOrder(Long chatId){
        List<PlateDto> list = new ArrayList<PlateDto>();
        list.add(new PlateDto(1,"Sardinas al vapor",12.5,"platos de sardinas al vapor"));
        list.add(new PlateDto(2,"Hamburguejas",30.5,"hamburguesas de lentejas"));
        list.add(new PlateDto(3,"Lasaña de pollo",50.5,"Lasaña con salsa roja y trositos de pollo"));

        OrderDto result = new OrderDto(list,93.5,"4-17-2020");
        return result;
    }
}
