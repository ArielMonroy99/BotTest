package bo.edu.ucb.ingsoft.rest.delivery.api;

import bo.edu.ucb.ingsoft.rest.delivery.bl.OrderBl;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.ClientDbDto;
//import bo.edu.ucb.ingsoft.rest.delivery.dto.db.OrderApiDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/order")
public class OrderApi {
    private OrderBl orderBl;


    public OrderApi(OrderBl orderBl) {
        this.orderBl = orderBl;
    }

//    @PostMapping(path= "/", consumes = APPLICATION_JSON_VALUE,
//            produces = APPLICATION_JSON_VALUE)
//    public ClientDbDto saveClient(@RequestBody OrderApiDto order){
//        return orderBl.creatNewClient(cliente);
//    }
}
