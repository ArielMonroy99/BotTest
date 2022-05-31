package bo.edu.ucb.ingsoft.rest.delivery.dto.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class OrderDbDto {
    private Integer pedidoId;
    private CardDbDto tarjetaDto;
    private AddressDbDto direccionDto;
    private Integer encargadoId; //FIXME: pedir encargado Id
    private Integer sucursalId;
    private Date fecha;
    private Integer estado;
    private Integer metodoDePago;
    private Integer metodoDeEntrega;
    private BigDecimal total;
    private Integer status;
    private Integer txId;
    private String txHost;
    private Date txDate;

    public OrderDbDto(Integer pedidoId, CardDbDto tarjetaDto, AddressDbDto direccionDto, Integer encargadoId, Integer sucursalId, Date fecha, Integer estado, Integer metodoDePago, Integer metodoDeEntrega, BigDecimal total, Integer status, Integer txId, String txHost, Date txDate) {
        this.pedidoId = pedidoId;
        this.tarjetaDto = tarjetaDto;
        this.direccionDto = direccionDto;
        this.encargadoId = encargadoId;
        this.sucursalId = sucursalId;
        this.fecha = fecha;
        this.estado = estado;
        this.metodoDePago = metodoDePago;
        this.metodoDeEntrega = metodoDeEntrega;
        this.total = total;
        this.status = status;
        this.txId = txId;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public CardDbDto getTarjetaDto() {
        return tarjetaDto;
    }

    public void setTarjetaDto(CardDbDto tarjetaDto) {
        this.tarjetaDto = tarjetaDto;
    }

    public AddressDbDto getDireccionDto() {
        return direccionDto;
    }

    public void setDireccionDto(AddressDbDto direccionDto) {
        this.direccionDto = direccionDto;
    }

    public Integer getEncargadoId() {
        return encargadoId;
    }

    public void setEncargadoId(Integer encargadoId) {
        this.encargadoId = encargadoId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTxId() {
        return txId;
    }

    public void setTxId(Integer txId) {
        this.txId = txId;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDbDto that = (OrderDbDto) o;
        return Objects.equals(pedidoId, that.pedidoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedidoId);
    }

    @Override
    public String toString() {
        return "PedidoDbDto{" +
                "pedidoId=" + pedidoId +
                ", tarjetaDto=" + tarjetaDto +
                ", direccionDto=" + direccionDto +
                ", encargadoId=" + encargadoId +
                ", sucursalId=" + sucursalId +
                ", fecha=" + fecha +
                ", estado=" + estado +
                ", metodoDePago=" + metodoDePago +
                ", metodoDeEntrega=" + metodoDeEntrega +
                ", total=" + total +
                ", status=" + status +
                ", txId=" + txId +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }
}
