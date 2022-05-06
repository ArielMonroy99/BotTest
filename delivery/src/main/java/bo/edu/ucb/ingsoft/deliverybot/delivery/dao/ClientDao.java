package bo.edu.ucb.ingsoft.deliverybot.delivery.dao;

import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.ClientDto;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.OrderDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Service
public interface ClientDao {

    @Select("Select cliente_id, nombre,nit,telefono,chat_id,status from cliente where chat_id = #{chatid} and status = 1")
    ClientDto getClientData(@Param("chatid")long chatid);

    @Select("select nextval('cliente_cliente_id_seq')")
    int getNextClientId();

    @Insert("Insert into cliente (cliente_id, nombre, nit, telefono, chat_id, status) " +
            "values (#{cliente_id},#{nombre},#{nit},#{telefono},#{chat_id},#{status})")
    void saveClient(ClientDto client);
}

