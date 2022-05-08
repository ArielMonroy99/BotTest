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
    public List<PlatoDto> Sopa(){ return platoDao.findAllSopa(); }
    public List<PlatoDto> Principal(){return platoDao.findAllPrincipal();}
    public List<PlatoDto> Postre(){ return platoDao.findAllPostre(); }

    public void guardarPlato(PlatoDto platoDto){
        platoDao.guardarPlato(platoDto);
    }

    public void actualizarPlato(PlatoDto platoDto){ platoDao.actualizarPlato(platoDto); }

    public void eliminarPlato(PlatoDto platoDto){ platoDao.eliminarPlato(platoDto); }
}
