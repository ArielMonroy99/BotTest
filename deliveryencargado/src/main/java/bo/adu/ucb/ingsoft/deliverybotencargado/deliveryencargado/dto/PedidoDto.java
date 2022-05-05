package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto;

public class PedidoDto {
    private Integer id;
    private Integer estado;

    public PedidoDto(Integer id,Integer estado) {
        this.id = id;
        this.estado = estado;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getEstado() { return estado; }

    public void setEstado(Integer estado) { this.estado = estado; }

}
