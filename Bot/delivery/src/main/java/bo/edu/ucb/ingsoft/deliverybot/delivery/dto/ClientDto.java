package bo.edu.ucb.ingsoft.deliverybot.delivery.dto;

public class ClientDto {
    private int cliente_id;
    private String nombre;
    private String nit;
    private String telefono;
    private long chat_id;
    private int status;

    public ClientDto (){

    }
    public ClientDto(int cliente_id, String nombre, String nit, String telefono, long chat_id, int status) {
        this.cliente_id = cliente_id;
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.chat_id = chat_id;
        this.status = status;
    }


    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public long getChat_id() {
        return chat_id;
    }

    public void setChat_id(long chat_id) {
        this.chat_id = chat_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "cliente_id=" + cliente_id +
                ", nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", telefono='" + telefono + '\'' +
                ", chat_id=" + chat_id +
                ", status=" + status +
                '}';
    }
}
