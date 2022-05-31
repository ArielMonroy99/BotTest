package bo.edu.ucb.ingsoft.rest.delivery.dto.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class PlateDbDto {
    public final static String SEQUENCE_NAME="plato_plato_id_seq";


    private Integer plato_id;
    private String nombre;
    private BigDecimal precio;
    private String descripcion;
    private String imagen_url;
    private Integer categoria_categoria_id;
    private Integer status;
    private Integer txId;
    private Date txDate;
    private String txHost;

    public PlateDbDto()
    {}

    public PlateDbDto(Integer plato_id, String nombre, BigDecimal precio, String descripcion, String imagen_url, Integer categoria_categoria_id, Integer status, Integer txId, Date txDate,  String txHost) {
        this.plato_id = plato_id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagen_url = imagen_url;
        this.categoria_categoria_id = categoria_categoria_id;
        this.status = status;
        this.txId = txId;
        this.txDate = txDate;
        this.txHost = txHost;
    }

    public Integer getPlato_id() {
        return plato_id;
    }

    public void setPlato_id(Integer plato_id) {
        this.plato_id = plato_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }

    public Integer getCategoria_categoria_id() {
        return categoria_categoria_id;
    }

    public void setCategoria_categoria_id(Integer categoria_categoria_id) {
        this.categoria_categoria_id = categoria_categoria_id;
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

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlateDbDto that = (PlateDbDto) o;
        return Objects.equals(plato_id, that.plato_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plato_id);
    }

    @Override
    public String toString() {
        return "PlateDbDto{" +
                "plato_id=" + plato_id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", imagen_url='" + imagen_url + '\'' +
                ", categoria_categoria_id=" + categoria_categoria_id +
                ", status=" + status +
                ", txId=" + txId +
                ", txDate=" + txDate +'\'' +
                ", txHost='" + txHost +
                '}';
    }
}
