package bo.edu.ucb.ingsoft.deliverybot.delivery.dto;

import java.sql.Date;

public class CancelationDto {
    private int cancelacion_id;
    private String razon;
    private Date hora_de_cancelacion;
    private OrderDto pedido;
    private int status;

    public CancelationDto(int cancelacion_id, String razon, Date hora_de_cancelacion, OrderDto pedido, int status) {
        this.cancelacion_id = cancelacion_id;
        this.razon = razon;
        this.hora_de_cancelacion = hora_de_cancelacion;
        this.pedido = pedido;
        this.status = status;
    }

    public int getCancelacion_id() {
        return cancelacion_id;
    }

    public void setCancelacion_id(int cancelacion_id) {
        this.cancelacion_id = cancelacion_id;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public Date getHora_de_cancelacion() {
        return hora_de_cancelacion;
    }

    public void setHora_de_cancelacion(Date hora_de_cancelacion) {
        this.hora_de_cancelacion = hora_de_cancelacion;
    }

    public OrderDto getPedido() {
        return pedido;
    }

    public void setPedido(OrderDto pedido) {
        this.pedido = pedido;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
