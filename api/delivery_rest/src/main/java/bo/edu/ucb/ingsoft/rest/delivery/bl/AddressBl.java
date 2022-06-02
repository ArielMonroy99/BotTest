package bo.edu.ucb.ingsoft.rest.delivery.bl;

import bo.edu.ucb.ingsoft.rest.delivery.dao.AddressDao;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.AddressApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.AddressDbDto;
import org.springframework.stereotype.Service;

@Service
public class AddressBl {
    private AddressDao addressDao;

    public AddressBl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    AddressApiDto getAddressById(Integer direccionId){
        AddressDbDto add = addressDao.getAddressById(direccionId);
        AddressApiDto newAdd = new AddressApiDto();
        newAdd.setId(add.getDireccionId());
        newAdd.setDetalle(add.getNota());
        newAdd.setDireccion(add.getDireccion());
        newAdd.setLatitud(add.getLatitud());
        newAdd.setLongitud(add.getLongitud());
        return newAdd;
    }
}
