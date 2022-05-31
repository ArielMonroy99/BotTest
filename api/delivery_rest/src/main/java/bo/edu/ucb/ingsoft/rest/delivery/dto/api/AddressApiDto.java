package bo.edu.ucb.ingsoft.rest.delivery.dto.api;

import java.util.Objects;

public class AddressApiDto {
    private Integer direccionId;
    private Double latitud;
    private Double longitud;
    private String direccion;
    private String nota;

    public AddressApiDto(Integer direccionId, Double latitud, Double longitud, String direccion, String nota) {
        this.direccionId = direccionId;
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccion = direccion;
        this.nota = nota;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressApiDto that = (AddressApiDto) o;
        return Objects.equals(direccionId, that.direccionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direccionId);
    }

    @Override
    public String toString() {
        return "AddressApiDto{" +
                "direccionId=" + direccionId +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", direccion='" + direccion + '\'' +
                ", nota='" + nota + '\'' +
                '}';
    }
}
