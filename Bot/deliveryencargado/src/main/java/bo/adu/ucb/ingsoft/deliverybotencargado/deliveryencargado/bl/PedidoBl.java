package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.bl;

import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dao.PedidoDao;
import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto.PedidoDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoBl {
    private PedidoDao pedidoDao;

    @Autowired
    public PedidoBl(PedidoDao pedidoDao){ this.pedidoDao = pedidoDao; }
    public List<PedidoDto> Pedidos(){
        return pedidoDao.findAllPedidos();
    }
}
