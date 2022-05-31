package bo.edu.ucb.ingsoft.rest.delivery.dto.api;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class OrderApiDto {
    private Integer pedidoId;
    private CardApiDto tarjetaDto;
    private AddressApiDto direccionDto;
    private Integer sucursalId;
    private Date fecha;
    private Integer estado;
    private Integer metodoDePago;
    private Integer metodoDeEntrega;
    private BigDecimal total;

    public OrderApiDto(Integer pedidoId, CardApiDto tarjetaDto, AddressApiDto direccionDto, Integer sucursalId, Date fecha, Integer estado, Integer metodoDePago, Integer metodoDeEntrega, BigDecimal total) {
        this.pedidoId = pedidoId;
        this.tarjetaDto = tarjetaDto;
        this.direccionDto = direccionDto;
        this.sucursalId = sucursalId;
        this.fecha = fecha;
        this.estado = estado;
        this.metodoDePago = metodoDePago;
        this.metodoDeEntrega = metodoDeEntrega;
        this.total = total;
    }

    public CardApiDto getTarjetaDto() {
        return tarjetaDto;
    }

    public void setTarjetaDto(CardApiDto tarjetaDto) {
        this.tarjetaDto = tarjetaDto;
    }

    public AddressApiDto getDireccionDto() {
        return direccionDto;
    }

    public void setDireccionDto(AddressApiDto direccionDto) {
        this.direccionDto = direccionDto;
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
                ", tarjetaDto=" + tarjetaDto +
                ", direccionDto=" + direccionDto +
                ", sucursalId=" + sucursalId +
                ", fecha=" + fecha +
                ", estado=" + estado +
                ", metodoDePago=" + metodoDePago +
                ", metodoDeEntrega=" + metodoDeEntrega +
                ", total=" + total +
                '}';
    }
}
