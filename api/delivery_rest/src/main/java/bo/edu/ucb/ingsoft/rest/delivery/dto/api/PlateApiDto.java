package bo.edu.ucb.ingsoft.rest.delivery.dto.api;

import java.math.BigDecimal;
import java.util.Objects;

public class PlateApiDto {
    private Integer plateId;
    private String nombre;
    private BigDecimal precio;
    private String descripcion;
    private String imagen;
    private Integer categoria;

    public PlateApiDto(Integer plateId, String nombre, BigDecimal precio, String descripcion, String imagen, Integer categoria) {
        this.plateId = plateId;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.categoria = categoria;
    }

    public PlateApiDto() {

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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlateApiDto that = (PlateApiDto) o;
        return Objects.equals(plateId, that.plateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateId);
    }

}
