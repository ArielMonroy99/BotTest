package bo.edu.ucb.ingsoft.rest.delivery.dao;

import bo.edu.ucb.ingsoft.rest.delivery.dto.api.AddressApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.AddressDbDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Service
public interface AddressDao {
    @Select("Select id as direccion_id,latitud,longitud,direccion,nota,status," +
            "tx_id,tx_host,tx_date from direccion where id = #{direccionId} and status = 1")
    AddressDbDto getAddressById(@Param("direccionId")Integer direccionId);

}
