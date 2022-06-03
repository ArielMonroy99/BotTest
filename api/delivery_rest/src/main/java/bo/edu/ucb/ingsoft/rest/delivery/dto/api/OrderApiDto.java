package bo.edu.ucb.ingsoft.rest.delivery.dto.api;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OrderApiDto {
    private Integer pedidoId;
    private Integer clientId;
    private CardApiDto tarjeta;
    private AddressApiDto direccion;
    private Integer sucursalId;
    private Date fecha;
    private List<PlateInOrderApiDto> platos;
    private Integer estado;
    private Integer metodoDePago;
    private Integer metodoDeEntrega;
    private BigDecimal total;
    private BigDecimal propina;



    public OrderApiDto(Integer pedidoId, CardApiDto tarjetaDto, AddressApiDto direccionDto, Integer sucursalId, Date fecha, List<PlateInOrderApiDto> platos, Integer estado, Integer metodoDePago, Integer metodoDeEntrega, BigDecimal total) {
        this.pedidoId = pedidoId;
        this.tarjeta = tarjetaDto;
        this.direccion = direccionDto;
        this.sucursalId = sucursalId;
        this.fecha = fecha;
        this.platos = platos;
        this.estado = estado;
        this.metodoDePago = metodoDePago;
        this.metodoDeEntrega = metodoDeEntrega;
        this.total = total;
    }

    public OrderApiDto() {

    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getPropina() {
        return propina;
    }

    public void setPropina(BigDecimal propina) {
        this.propina = propina;
    }

    public List<PlateInOrderApiDto> getPlatos() {
        return platos;
    }

    public void setPlatos(List<PlateInOrderApiDto> platos) {
        this.platos = platos;
    }

    public CardApiDto getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(CardApiDto tarjeta) {
        this.tarjeta = tarjeta;
    }

    public AddressApiDto getDireccion() {
        return direccion;
    }

    public void setDireccion(AddressApiDto direccion) {
        this.direccion = direccion;
    }

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }



    public Integer getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Integer sucursalId) {
        this.sucursalId = sucursalId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(Integer metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public Integer getMetodoDeEntrega() {
        return metodoDeEntrega;
    }

    public void setMetodoDeEntrega(Integer metodoDeEntrega) {
        this.metodoDeEntrega = metodoDeEntrega;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderApiDto that = (OrderApiDto) o;
        return Objects.equals(pedidoId, that.pedidoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedidoId);
    }

    @Override
    public String toString() {
        return "OrderApiDto{" +
                "pedidoId=" + pedidoId +
                ", tarjeta=" + tarjeta +
                ", direccion=" + direccion +
                ", sucursalId=" + sucursalId +
                ", fecha=" + fecha +
                ", platos=" + platos +
                ", estado=" + estado +
                ", metodoDePago=" + metodoDePago +
                ", metodoDeEntrega=" + metodoDeEntrega +
                ", total=" + total +
                ", propina=" + propina +
                '}';
    }
}
