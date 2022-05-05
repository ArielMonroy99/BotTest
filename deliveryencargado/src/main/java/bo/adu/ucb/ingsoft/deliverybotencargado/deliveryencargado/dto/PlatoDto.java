package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto;

public class PlatoDto {
    private Integer id;
    private String nombre;
    private Double precio;
    private String descripcion;
    private String img;
    private int categoria;
    private int status;

    public PlatoDto(){
    }

    public PlatoDto(Integer id, String nombre, Double precio, String descripcion,String img,int categoria,int status){
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCategoria() { return categoria; }

    public void setCategoria(int categoria) { this.categoria = categoria; }

    public int getStatus() { return status; }

    public void setStatus(int status) { this.status = status; }

    @Override
    public String toString() {
        return "Nombre: " + nombre + '\n' +
                "Precio: " + precio +'\n' +
                "Descripción: " + descripcion + '\n';
    }
}
