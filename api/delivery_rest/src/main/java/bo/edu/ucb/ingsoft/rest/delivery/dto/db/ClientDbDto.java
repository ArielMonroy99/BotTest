package bo.edu.ucb.ingsoft.rest.delivery.dto.db;

import java.util.Date;
import java.util.Objects;

public class ClientDbDto {
    public final static String SEQUENCE_NAME="cliente_cliente_id_seq";

    private Integer clientId;
    private String nombre;
    private String nit;
    private String telefono;
    private String usuario;
    private String password;
    private String correo;
    private String imagen;
    private Integer status;
    private Integer txId;
    private String txHost;
    private Date txDate;

    public ClientDbDto()
    {}

    public ClientDbDto(Integer clientId, String nombre, String nit, String telefono, String usuario, String password, String correo, String imagen, Integer status, Integer txId, String txHost, Date txDate) {
        this.clientId = clientId;
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.usuario = usuario;
        this.password = password;
        this.correo = correo;
        this.imagen = imagen;
        this.status = status;
        this.txId = txId;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        ClientDbDto that = (ClientDbDto) o;
        return Objects.equals(clientId, that.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }

    @Override
    public String toString() {
        return "ClientDbDto{" +
                "clientId=" + clientId +
                ", nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", telefono='" + telefono + '\'' +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", correo='" + correo + '\'' +
                ", imagen='" + imagen + '\'' +
                ", status=" + status +
                ", txId=" + txId +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }
}