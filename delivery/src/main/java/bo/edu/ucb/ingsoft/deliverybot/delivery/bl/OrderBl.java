package bo.edu.ucb.ingsoft.deliverybot.delivery.bl;

import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.OrderDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.PlateInOrderDto;

import java.util.ArrayList;
import java.util.List;

public class OrderBl {
    public OrderBl(){

    }
    public OrderDto findLastOrder(Long chatId){
        List<PlateInOrderDto> list = new ArrayList<PlateInOrderDto>();
        list.add(new PlateInOrderDto(new PlateDto(1,"Sardinas al vapor",12.5,"platos de sardinas al vapor"),1));
        list.add(new PlateInOrderDto(new PlateDto(2,"Hamburguejas",30.5,"hamburguesas de lentejas"),1));
        list.add(new PlateInOrderDto(new PlateDto(3,"Lasaña de pollo",50.5,"Lasaña con salsa roja y trositos de pollo"),1));

        OrderDto result = new OrderDto(list,93.5,"4-17-2020");
        return result;
    }
    public List<OrderDto> findLas10Orders(Long chatId){

        List<OrderDto> result = new ArrayList<OrderDto>();
        List<PlateInOrderDto> list = new ArrayList<PlateInOrderDto>();
        list.add(new PlateInOrderDto(new PlateDto(1,"Sardinas al vapor",12.5,"platos de sardinas al vapor"),1));
        list.add(new PlateInOrderDto(new PlateDto(2,"Hamburguejas",30.5,"hamburguesas de lentejas"),1));
        list.add(new PlateInOrderDto(new PlateDto(3,"Lasaña de pollo",50.5,"Lasaña con salsa roja y trositos de pollo"),1));
        List<PlateInOrderDto> list1 = new ArrayList<PlateInOrderDto>();
        list1.add(new PlateInOrderDto(new PlateDto(1,"Sardinas al vapor",12.5,"platos de sardinas al vapor"),1));
        list1.add(new PlateInOrderDto(new PlateDto(2,"Hamburguejas",30.5,"hamburguesas de lentejas"),1));
        list1.add(new PlateInOrderDto(new PlateDto(3,"Lasaña de pollo",50.5,"Lasaña con salsa roja y trositos de pollo"),1));

        List<PlateInOrderDto> list2 = new ArrayList<PlateInOrderDto>();
        list2.add(new PlateInOrderDto(new PlateDto(1,"Sardinas al vapor",12.5,"platos de sardinas al vapor"),1));
        list2.add(new PlateInOrderDto(new PlateDto(2,"Hamburguejas",30.5,"hamburguesas de lentejas"),1));
        list2.add(new PlateInOrderDto(new PlateDto(3,"Lasaña de pollo",50.5,"Lasaña con salsa roja y trositos de pollo"),1));

        result.add(new OrderDto(list,93.5,"4-17-2020") );
        result.add(new OrderDto(list1,93.5,"4-10-2020") );
        result.add(new OrderDto(list2,93.5,"3-23-2020") );

        return result;
    }
}
