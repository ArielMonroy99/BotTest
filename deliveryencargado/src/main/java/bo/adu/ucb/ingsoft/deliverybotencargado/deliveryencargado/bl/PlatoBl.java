package bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.bl;

import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dao.PlatoDao;
import bo.adu.ucb.ingsoft.deliverybotencargado.deliveryencargado.dto.PlatoDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PlatoBl {
    private PlatoDao platoDao;



    @Autowired
    public PlatoBl(PlatoDao platoDao){
        this.platoDao = platoDao;
    }
    public List<PlatoDto> TodayMenu(){
        return platoDao.findAllPlates();
    }

    public void guardarPlato(PlatoDto platoDto){
        platoDao.guardarPlato(platoDto);
    }
}
