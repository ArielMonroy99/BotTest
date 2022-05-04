package bo.edu.ucb.ingsoft.deliverybot.delivery.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDto {
    private int id;
    private ClienteDto Cliente;
    private List<PlateInOrderDto> listaPlatos;
    private int estado;
    private Date fecha;
    private int longitud;
    private int latitud;
    private int metodoDePago;
    private int delivery;
    private BigDecimal total;
    private int status;

    public OrderDto(){

    }
    public OrderDto(int id, ClienteDto cliente, List<PlateInOrderDto> listaPlatos, int estado, Date fecha, int longitud, int latitud, int metodoDePago, int delivery, BigDecimal total, int status) {
        this.id = id;
        Cliente = cliente;
        this.listaPlatos = listaPlatos;
        this.estado = estado;
        this.fecha = fecha;
        this.longitud = longitud;
        this.latitud = latitud;
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

    public ClienteDto getCliente() {
        return Cliente;
    }

    public void setCliente(ClienteDto cliente) {
        Cliente = cliente;
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

    public Date getFecha(Date date) {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
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
