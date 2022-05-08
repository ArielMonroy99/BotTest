package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PlatoDto {
    private Integer id;
    private String nombre;
    private BigDecimal precio;
    private String descripcion;
    private String img;
    private Integer categoria;
    private Integer status;

    public PlatoDto(){
    }

    public PlatoDto(Integer id, String nombre, BigDecimal precio, String descripcion,String img,Integer categoria,Integer status){
        this.id =id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.img = img;
        this.categoria = categoria;
        this.status = status;
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

    public Integer getCategoria() { return categoria; }

    public void setCategoria(Integer categoria) { this.categoria = categoria; }

    public Integer getStatus() { return status; }

    public void setStatus(Integer status) { this.status = status; }

    @Override
    public String toString() {
        return "Nombre: " + nombre + '\n' +
                "Precio: " + precio +'\n' +
                "Descripción: " + descripcion + '\n';
    }
}
