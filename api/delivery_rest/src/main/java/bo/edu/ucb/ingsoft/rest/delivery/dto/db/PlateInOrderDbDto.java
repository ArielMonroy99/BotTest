package bo.edu.ucb.ingsoft.rest.delivery.dto.db;

import java.math.BigDecimal;
import java.util.Objects;

public class PlateInOrderDbDto {
    private Integer plateId;
    private String nombre;
    private Integer orderId;
    private Integer cantidad;
    private String nota;

    public PlateInOrderDbDto() {
    }

    public PlateInOrderDbDto(Integer plateId, String nombre, Integer cantidad, String nota) {
        this.plateId = plateId;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.nota = nota;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getPlateId() {
        return plateId;
    }

    public void setPlateId(Integer plateId) {
        this.plateId = plateId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlateInOrderDbDto that = (PlateInOrderDbDto) o;
        return Objects.equals(plateId, that.plateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateId);
    }

    @Override
    public String toString() {
        return "PlateInOrderDbDto{" +
                "plateId=" + plateId +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", nota='" + nota + '\'' +
                '}';
    }
}
