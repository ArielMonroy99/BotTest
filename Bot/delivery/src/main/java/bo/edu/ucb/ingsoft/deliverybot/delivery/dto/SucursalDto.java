package bo.edu.ucb.ingsoft.deliverybot.delivery.dto;

public class SucursalDto {
    private int sucursal_id;
    private String direccion;
    private String zona;
    private double latitud;
    private double longitud;

    public SucursalDto(int sucursal_id, String direccion,String zona, double latitud, double longitud) {
        this.zona = zona;
        this.sucursal_id = sucursal_id;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public int getSucursal_id() {
        return sucursal_id;
    }

    public void setSucursal_id(int sucursal_id) {
        this.sucursal_id = sucursal_id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return  "Sucursal : "+sucursal_id +"\n"+
                "Direccion: " + direccion + "\n" +
                "Zona: " + zona + "\n";
    }
}
