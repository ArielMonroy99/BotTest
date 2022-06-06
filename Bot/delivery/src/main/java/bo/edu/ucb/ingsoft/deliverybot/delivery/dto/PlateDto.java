package bo.edu.ucb.ingsoft.deliverybot.delivery.dto;

import java.math.BigDecimal;

public class PlateDto {
    private Integer id;
    private String nombre;
    private BigDecimal precio;
    private String descripcion;
    private String img;




    public PlateDto(){
    }

    public PlateDto(Integer id, String nombre, BigDecimal precio, String descripcion,String img){
        this.id =id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.img = img;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    @Override
    public String toString() {
        return "Nombre: " + nombre + '\n' +
                "Precio: " + precio +'\n' +
                "Descripción: " + descripcion + '\n';
    }
}
