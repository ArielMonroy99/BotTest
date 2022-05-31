package bo.edu.ucb.ingsoft.rest.delivery.dto.db;

import java.util.Date;
import java.util.Objects;

public class AddressDbDto {
    private Integer direccionId;
    private Double latitud;
    private Double longitud;
    private String direccion;
    private String nota;
    private Integer status;
    private Integer txId;
    private String txHost;
    private Date txDate;

    public AddressDbDto(Integer direccionId, Double latitud, Double longitud, String direccion, String nota, Integer status, Integer txId, String txHost, Date txDate) {
        this.direccionId = direccionId;
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccion = direccion;
        this.nota = nota;
        this.status = status;
        this.txId = txId;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getDireccionId() {
        return direccionId;
    }

    public void setDireccionId(Integer direccionId) {
        this.direccionId = direccionId;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
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
        AddressDbDto that = (AddressDbDto) o;
        return Objects.equals(direccionId, that.direccionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direccionId);
    }

    @Override
    public String toString() {
        return "DireccionDbDto{" +
                "direccionId=" + direccionId +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", direccion='" + direccion + '\'' +
                ", nota='" + nota + '\'' +
                ", status=" + status +
                ", txId=" + txId +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }
}
