package bo.edu.ucb.ingsoft.rest.delivery.bl;

import bo.edu.ucb.ingsoft.rest.delivery.api.OrderApi;
import bo.edu.ucb.ingsoft.rest.delivery.dao.*;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.OrderApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.PlateApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.PlateInOrderApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.OrderDbDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.PlateDbDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.PlateInOrderDbDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class OrderBl {
    private OrderDao orderDao;
    private SequenceDao sequenceDao;
    private CardBl cardBl;
    private AddressBl addressBl;
    public static final Logger LOGGER = LoggerFactory.getLogger(OrderBl.class);

    public OrderBl(OrderDao orderDao, SequenceDao sequenceDao, CardBl cardBl, AddressBl addressBl) {
        this.orderDao = orderDao;
        this.sequenceDao = sequenceDao;
        this.cardBl = cardBl;
        this.addressBl = addressBl;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public OrderApiDto createNewOrder(OrderApiDto order,Integer clientId){
        OrderDbDto newOrder = new OrderDbDto();
        newOrder.setPedidoId(sequenceDao.getSequence(OrderDbDto.sequence));
        newOrder.setEncargadoId(1);
        newOrder.setSucursalId(order.getSucursalId());
        order.setFecha(new Date());
        order.setPedidoId(newOrder.getPedidoId());
        newOrder.setFecha(order.getFecha());
        newOrder.setEstado(1);
        newOrder.setClientId(clientId);
        newOrder.setMetodoDeEntrega(order.getMetodoDeEntrega());
        newOrder.setMetodoDePago(order.getMetodoDePago());
        newOrder.setTarjetaId(order.getTarjeta().getId());
        newOrder.setDireccionId(order.getDireccion().getId());
        newOrder.setTotal(order.getTotal());
        newOrder.setPropina(order.getPropina());
        newOrder.setStatus(1);
        newOrder.setTxDate(new Date());
        newOrder.setTxHost("localhost");
        newOrder.setTxId(1);
        LOGGER.info(newOrder.toString());
        orderDao.saveOrder(newOrder);
        for(PlateInOrderApiDto plate : order.getPlatos()){
            PlateInOrderDbDto newPlate = new PlateInOrderDbDto();
            newPlate.setPlateId(plate.getId());
            newPlate.setOrderId(newOrder.getPedidoId());
            newPlate.setCantidad(plate.getCantidad());
            newPlate.setNota(plate.getNota());
            orderDao.savePlatesInOrder(newPlate);
        }

        return order;
    }


    public OrderApiDto getOrderById(Integer orderId){
        OrderDbDto newOrder = orderDao.findByOrderId(orderId);
        LOGGER.info("Order: {}",newOrder.toString());
        OrderApiDto order = new OrderApiDto();
        order.setPedidoId(newOrder.getPedidoId());
        order.setTarjeta(cardBl.getCardById(newOrder.getTarjetaId()));
        order.setDireccion(addressBl.getAddressById(newOrder.getDireccionId()));
        order.setSucursalId(newOrder.getSucursalId());
        try{
            SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            isoFormat.setTimeZone(TimeZone.getTimeZone("UTC-4"));
            Date date = isoFormat.parse(newOrder.getFecha().toString());
            order.setFecha(date);
        }catch (ParseException ex ){
            LOGGER.info("Error al tratar de convertir fecha");
            order.setFecha(newOrder.getFecha());
        }
        List<PlateInOrderDbDto> list = orderDao.findPlatesInOrder(newOrder.getPedidoId());
        List<PlateInOrderApiDto> newList = new ArrayList<>();
        for(PlateInOrderDbDto plate: list){
            LOGGER.info("plate:{}",plate);
            PlateInOrderApiDto plateApi = new PlateInOrderApiDto();
            plateApi.setId(plate.getPlateId());
            plateApi.setCantidad(plate.getCantidad());
            plateApi.setNota(plate.getNota());
            newList.add(plateApi);
        }
        order.setPlatos(newList);
        order.setEstado(newOrder.getEstado());
        order.setMetodoDePago(newOrder.getMetodoDePago());
        order.setMetodoDeEntrega(newOrder.getMetodoDeEntrega());
        order.setTotal(newOrder.getTotal());
        order.setPropina(newOrder.getPropina());
        return order;

    }
    public List<OrderApiDto> getOrdersByClient(Integer clientId,Integer pageSize,Integer page){
        LOGGER.info("pageSize:{}, pageNumber:{}",pageSize,page);
        if(pageSize == null){
            pageSize = 5;
        }

        if(page == null){
            page = 0;
        }
        List<OrderApiDto> newList = new ArrayList<>();
        List<OrderDbDto> list = orderDao.orderList(clientId,pageSize,page*pageSize);
        for(OrderDbDto order: list){
            LOGGER.info("pedido:{}",order.toString());
            OrderApiDto newOrder = new OrderApiDto();
            newOrder.setPedidoId(order.getPedidoId());
            newOrder.setFecha(order.getFecha());
            newOrder.setTotal(order.getTotal());
            newOrder.setSucursalId(order.getSucursalId());
            newOrder.setEstado(order.getEstado());
            newOrder.setMetodoDeEntrega(order.getMetodoDeEntrega());
            newOrder.setMetodoDePago(order.getMetodoDePago());
            newList.add(newOrder);
        }
        return newList;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public OrderDbDto updateOrder(OrderApiDto newOrder , int orderId){
        OrderDbDto order = new OrderDbDto();
        order.setPedidoId(orderId);
        order.setEstado(newOrder.getEstado());
        order.setTxDate(new Date());
        order.setTxHost("localhost");
        order.setTxId(1);
        //logger.debug(plate.toString());
        orderDao.updateOrder(order);
        return order;
    }

    public List<OrderApiDto> findAllOrder(Integer estado){
        List<OrderApiDto> orderApiDto = orderDao.findAllOrder(estado);
        return orderApiDto;
    }
}
