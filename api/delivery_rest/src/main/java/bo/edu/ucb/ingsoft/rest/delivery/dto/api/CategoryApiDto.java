package bo.edu.ucb.ingsoft.rest.delivery.dto.api;

import java.util.Objects;

public class CategoryApiDto {
    private Integer categoryId;
    private String nombre;
    private String image_url;

    public CategoryApiDto(Integer categoryId, String nombre, String image_url){
        this.categoryId = categoryId;
        this.nombre = nombre;
        this.image_url = image_url;
    }

    public CategoryApiDto () {}

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setImage(String nombre) {
        this.image_url = image_url;
    }

    public String getImage() {
        return image_url;
    }

}
