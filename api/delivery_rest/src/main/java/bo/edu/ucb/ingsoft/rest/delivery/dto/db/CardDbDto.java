package bo.edu.ucb.ingsoft.rest.delivery.dto.db;

import java.util.Date;
import java.util.Objects;

public class CardDbDto {
    public static final String  SEQUENCE = "tarjeta_id_seq";
    private Integer tarjetaId;
    private String nro;
    private String vencimiento;
    private String nombre;
    private Integer clientId;
    private Integer status;
    private Integer txId;
    private String txHost;
    private Date txDate;

    public CardDbDto(Integer tarjetaId, String nro, String vencimiento, String nombre, Integer status, Integer txId, String txHost, Date txDate) {
        this.tarjetaId = tarjetaId;
        this.nro = nro;
        this.vencimiento = vencimiento;
        this.nombre = nombre;
        this.status = status;
        this.txId = txId;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public CardDbDto() {

    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTarjetaId() {
        return tarjetaId;
    }

    public void setTarjetaId(Integer tarjetaId) {
        this.tarjetaId = tarjetaId;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
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
        CardDbDto that = (CardDbDto) o;
        return Objects.equals(tarjetaId, that.tarjetaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tarjetaId);
    }

    @Override
    public String toString() {
        return "CardDbDto{" +
                "tarjetaId=" + tarjetaId +
                ", nro='" + nro + '\'' +
                ", vencimiento='" + vencimiento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", status=" + status +
                ", txId=" + txId +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }
}
