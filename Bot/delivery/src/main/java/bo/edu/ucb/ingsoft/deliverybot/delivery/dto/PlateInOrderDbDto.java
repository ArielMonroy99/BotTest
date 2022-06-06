package bo.edu.ucb.ingsoft.deliverybot.delivery.dto;

public class PlateInOrderDbDto {
    private int plato_id;
    private int cantidad;

    public PlateInOrderDbDto(int plato_id, int cantidad) {
        this.plato_id = plato_id;
        this.cantidad = cantidad;
    }

    public int getPlato_id() {
        return plato_id;
    }

    @Override
    public String toString() {
        return "PlateInOrderDbDto{" +
                "plato_id=" + plato_id +
                ", cantidad=" + cantidad +
                '}';
    }

    public void setPlato_id(int plato_id) {
        this.plato_id = plato_id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
