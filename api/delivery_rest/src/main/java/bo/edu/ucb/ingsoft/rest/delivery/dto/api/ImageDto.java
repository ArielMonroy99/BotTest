package bo.edu.ucb.ingsoft.rest.delivery.dto.api;

public class ImageDto {
    private String imagen;
    private String imagenNombre;
    private String imagenFormato;

    public ImageDto(String imagen, String imagenNombre, String imagenFormato) {
        this.imagen = imagen;
        this.imagenNombre = imagenNombre;
        this.imagenFormato = imagenFormato;
    }

    public ImageDto() {

    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getImagenNombre() {
        return imagenNombre;
    }

    public void setImagenNombre(String imagenNombre) {
        this.imagenNombre = imagenNombre;
    }

    public String getImagenFormato() {
        return imagenFormato;
    }

    public void setImagenFormato(String imagenFormato) {
        this.imagenFormato = imagenFormato;
    }

    @Override
    public String toString() {
        return "ImageDto{" +
                "imagen='" + imagen + '\'' +
                ", imagenNombre='" + imagenNombre + '\'' +
                ", imagenFormato='" + imagenFormato + '\'' +
                '}';
    }
}
