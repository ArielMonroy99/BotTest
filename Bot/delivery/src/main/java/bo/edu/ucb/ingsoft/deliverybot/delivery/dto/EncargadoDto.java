package bo.edu.ucb.ingsoft.deliverybot.delivery.dto;

public class EncargadoDto {
    private int encargado_id;
    private String ci;
    private String nombre;
    private String telefono;
    private String password;
    private int status;

    public EncargadoDto(int encargado_id, String ci, String nombre, String telefono, String password, int status) {
        this.encargado_id = encargado_id;
        this.ci = ci;
        this.nombre = nombre;
        this.telefono = telefono;
        this.password = password;
        this.status = status;
    }

    public int getEncargado_id() {
        return encargado_id;
    }

    public void setEncargado_id(int encargado_id) {
        this.encargado_id = encargado_id;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EncargadoDto{" +
                "encargado_id=" + encargado_id +
                ", ci='" + ci + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
