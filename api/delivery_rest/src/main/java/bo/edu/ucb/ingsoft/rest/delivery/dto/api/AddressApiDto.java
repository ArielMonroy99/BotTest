package bo.edu.ucb.ingsoft.rest.delivery.dto.api;

import java.util.Objects;

public class AddressApiDto {
    private Integer id;
    private Double latitud;
    private Double longitud;
    private String direccion;
    private String detalle;

    public AddressApiDto(Integer direccionId, Double latitud, Double longitud, String direccion, String detalle) {
        this.id = direccionId;
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccion = direccion;
        this.detalle = detalle;
    }

    public AddressApiDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String nota) {
        this.detalle = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressApiDto that = (AddressApiDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AddressApiDto{" +
                "direccionId=" + id +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", direccion='" + direccion + '\'' +
                ", nota='" + detalle + '\'' +
                '}';
    }
}
