package bo.edu.ucb.ingsoft.deliverybot.delivery.dto;

import java.util.List;

public class OrderDto {
    private List<PlateDto> listaPlatos;
    private Double total;
    private String fecha;

    public OrderDto(List<PlateDto> listaPlatos, Double total, String fecha) {
        this.listaPlatos = listaPlatos;
        this.total = total;
        this.fecha = fecha;
    }

    public List<PlateDto> getListaPlatos() {
        return listaPlatos;
    }

    public void setListaPlatos(List<PlateDto> listaPlatos) {
        this.listaPlatos = listaPlatos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        int c = 1;
        StringBuffer sb = new StringBuffer();
        for(PlateDto plate:listaPlatos){
            sb.append("Nro :").append(c).append("\n");
            sb.append(plate.toString());
            c++;
        }

        return "lista de Platos:\n" + sb +"\n"+
                " Total: " + total +"\n"+
                "Fecha: " + fecha ;
    }
}
