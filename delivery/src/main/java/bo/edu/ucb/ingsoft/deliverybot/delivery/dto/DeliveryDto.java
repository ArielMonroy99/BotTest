package bo.edu.ucb.ingsoft.deliverybot.delivery.dto;

import java.sql.Date;

public class DeliveryDto {
    private int delivery_id;
    private OrderDto order;
    private int repartidor; //FIXME:AGREGAR REPARTIDORDTO
    private Date horaDeEnvio;
    private Date horaDeEntrega;
    private int status;

    public DeliveryDto(int delivery_id, OrderDto order, int repartidor, Date horaDeEnvio, Date horaDeEntrega, int status) {
        this.delivery_id = delivery_id;
        this.order = order;
        this.repartidor = repartidor;
        this.horaDeEnvio = horaDeEnvio;
        this.horaDeEntrega = horaDeEntrega;
        this.status = status;
    }

    public int getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }

    public int getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(int repartidor) {
        this.repartidor = repartidor;
    }

    public Date getHoraDeEnvio() {
        return horaDeEnvio;
    }

    public void setHoraDeEnvio(Date horaDeEnvio) {
        this.horaDeEnvio = horaDeEnvio;
    }

    public Date getHoraDeEntrega() {
        return horaDeEntrega;
    }

    public void setHoraDeEntrega(Date horaDeEntrega) {
        this.horaDeEntrega = horaDeEntrega;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
