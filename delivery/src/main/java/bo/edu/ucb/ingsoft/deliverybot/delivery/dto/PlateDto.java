package bo.edu.ucb.ingsoft.deliverybot.delivery.dto;

public class PlateDto {
    private Integer id;
    private String nombre;
    private Double precio;
    private String Desc;

    public PlateDto(){
    }

    public PlateDto(Integer id, String nombre, Double precio, String Desc){
        this.id =id;
        this.nombre = nombre;
        this.precio = precio;
        this.Desc = Desc;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    @Override
    public String toString() {
        return "PlateDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", Desc='" + Desc + '\'' +
                '}';
    }
}
