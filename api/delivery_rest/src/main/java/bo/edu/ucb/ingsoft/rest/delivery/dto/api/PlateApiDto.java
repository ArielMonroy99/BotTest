package bo.edu.ucb.ingsoft.rest.delivery.dto.api;

import java.math.BigDecimal;
import java.util.Objects;

public class PlateApiDto {
    private Integer platoId;
    private String nombre;
    private BigDecimal precio;
    private String descripcion;
    private String imagenUrl;
    private Integer categoriaCategoriaId;

    public PlateApiDto(Integer plato_id, String nombre, BigDecimal precio, String descripcion, String imagen_url, Integer categoria_categoria_id) {
        this.platoId = plato_id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagenUrl = imagen_url;
        this.categoriaCategoriaId = categoria_categoria_id;
    }

    public PlateApiDto() {

    }

    public Integer getPlatoId() {
        return platoId;
    }

    public void setPlatoId(Integer platoId) {
        this.platoId = platoId;
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

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public Integer getCategoriaCategoriaId() {
        return categoriaCategoriaId;
    }

    public void setCategoriaCategoriaId(Integer categoriaCategoriaId) {
        this.categoriaCategoriaId = categoriaCategoriaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlateApiDto that = (PlateApiDto) o;
        return Objects.equals(platoId, that.platoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(platoId);
    }

    @Override
    public String toString() {
        return "PlateApiDto{" +
                "platoId=" + platoId +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", imagenUrl='" + imagenUrl + '\'' +
                ", categoriaCategoriaId=" + categoriaCategoriaId +
                '}';
    }
}
