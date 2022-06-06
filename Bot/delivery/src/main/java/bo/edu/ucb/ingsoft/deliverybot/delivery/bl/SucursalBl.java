package bo.edu.ucb.ingsoft.deliverybot.delivery.bl;

import bo.edu.ucb.ingsoft.deliverybot.delivery.dao.SucursalDao;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.SucursalDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SucursalBl {
    private SucursalDao sucursalDao;

    @Autowired
    public SucursalBl(SucursalDao sucursalDao) {
        this.sucursalDao = sucursalDao;
    }

    public List<SucursalDto> findAllBranches(){
        return sucursalDao.findAllBranch();
    }

}
