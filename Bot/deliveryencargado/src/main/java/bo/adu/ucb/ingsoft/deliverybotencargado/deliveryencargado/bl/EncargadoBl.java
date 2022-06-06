package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.bl;

import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dao.EncargadoDao;
import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto.EncargadoDto;
import org.springframework.stereotype.Service;

@Service
public class EncargadoBl {
    private EncargadoDao encargadoDao;

    public  EncargadoBl(EncargadoDao encargadoDao){ this.encargadoDao = encargadoDao; }
    public EncargadoDto getEncargadoData(long chat_id){
        return encargadoDao.getEncargadoData(chat_id);
    }
}
