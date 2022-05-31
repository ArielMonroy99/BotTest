package bo.edu.ucb.ingsoft.rest.delivery.dto.api;

import java.util.Objects;

public class CardApiDto {
    private Integer tarjetaId;
    private String nro;
    private String vencimiento;
    private String nombre;

    public CardApiDto(Integer tarjetaId, String nro, String vencimiento, String nombre) {
        this.tarjetaId = tarjetaId;
        this.nro = nro;
        this.vencimiento = vencimiento;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardApiDto that = (CardApiDto) o;
        return Objects.equals(tarjetaId, that.tarjetaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tarjetaId);
    }

    @Override
    public String toString() {
        return "CardApiDto{" +
                "tarjetaId=" + tarjetaId +
                ", nro='" + nro + '\'' +
                ", vencimiento='" + vencimiento + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
