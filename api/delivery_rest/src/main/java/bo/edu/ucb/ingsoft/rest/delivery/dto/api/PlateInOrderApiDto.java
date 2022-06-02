package bo.edu.ucb.ingsoft.rest.delivery.dto.api;

public class PlateInOrderApiDto {
    private Integer id;
    private Integer cantidad;
    private String nota;

    public PlateInOrderApiDto(Integer plateId, Integer cantidad, String nota) {
        this.id = plateId;
        this.cantidad = cantidad;
        this.nota = nota;
    }

    public PlateInOrderApiDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public String toString() {
        return "PlateInOrderApiDto{" +
                "plateId=" + id +
                ", cantidad=" + cantidad +
                ", nota='" + nota + '\'' +
                '}';
    }
}
