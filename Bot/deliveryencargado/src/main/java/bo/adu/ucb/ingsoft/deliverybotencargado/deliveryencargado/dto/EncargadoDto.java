package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto;

public class EncargadoDto {
    private Integer id;
    private Integer sucursal;
    private String ci;
    private Integer telefono;
    private String password;
    private Integer status;
    private long chat_id;

    public  EncargadoDto(){

    }
    
    public EncargadoDto(Integer id, Integer sucursal, String ci, Integer telefono, String password, Integer status,long chat_id) {
        this.id = id;
        this.sucursal = sucursal;
        this.ci = ci;
        this.telefono = telefono;
        this.password = password;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSucursal() {
        return sucursal;
    }

    public void setSucursal(Integer sucursal) {
        this.sucursal = sucursal;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public long getChat_id() {
        return chat_id;
    }

    public void setChat_id(long chat_id) {
        this.chat_id = chat_id;
    }
}
