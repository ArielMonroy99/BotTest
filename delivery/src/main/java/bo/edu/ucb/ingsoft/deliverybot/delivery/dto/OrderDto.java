package bo.edu.ucb.ingsoft.deliverybot.delivery.dto;

import java.math.BigDecimal;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class OrderDto {
    private int id;
    private int  cliente_id;
    private List<PlateInOrderDto> listaPlatos;
    private int estado;
    private Timestamp fecha;
    private Double longitud;
    private Double latitud;
    private int encargado_id;
    private int metodoDePago;
    private int delivery;
    private BigDecimal total;
    private int status;

    public OrderDto(){

    }
    public OrderDto(int id, int cliente_id, List<PlateInOrderDto> listaPlatos, int estado, Timestamp fecha, Double longitud, Double latitud, int encargado_id, int metodoDePago, int delivery, BigDecimal total, int status) {
        this.id = id;
        this.cliente_id = cliente_id;
        this.listaPlatos = listaPlatos;
        this.estado = estado;
        this.fecha = fecha;
        this.longitud = longitud;
        this.latitud = latitud;
        this.encargado_id = encargado_id;
        this.metodoDePago = metodoDePago;
        this.delivery = delivery;
        this.total = total;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public List<PlateInOrderDto> getListaPlatos() {
        return listaPlatos;
    }

    public void setListaPlatos(List<PlateInOrderDto> listaPlatos) {
        this.listaPlatos = listaPlatos;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Timestamp getFecha(java.util.Date date) {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public int getEncargado_id() {
        return encargado_id;
    }

    public void setEncargado_id(int encargado_id) {
        this.encargado_id = encargado_id;
    }

    public int getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(int metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



    @Override
    public String toString() {
        int c = 1;
        StringBuffer sb = new StringBuffer();
        for(PlateInOrderDto plate:listaPlatos){
            sb.append("Nro :").append(c).append("\n");
            sb.append(plate.toString());
            c++;
        }

        return "Lista de Platos:\n" + sb +"\n"+
                "Total: " + total +"\n"+
                "Fecha: " + fecha ;
    }
    public String toString2() {
        StringBuffer sb = new StringBuffer();
        for(PlateInOrderDto plate:listaPlatos){
            sb.append("-").append(plate.getPlato().getNombre()).append(" x ").append(plate.getCantidad()).append("\n");
        }
        return "Lista de Platos:\n" + sb +"\n"+
                "Total: " + total +"\n"+
                "Fecha: " + fecha ;
    }
}
