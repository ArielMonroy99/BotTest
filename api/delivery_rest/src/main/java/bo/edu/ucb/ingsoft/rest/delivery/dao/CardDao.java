package bo.edu.ucb.ingsoft.rest.delivery.dao;

import bo.edu.ucb.ingsoft.rest.delivery.dto.db.CardDbDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.OrderDbDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardDao {
    @Select("Select id as tarjetaId, nro , venc as vencimiento,nombre,status,tx_id,tx_host,tx_date from tarjeta where id = #{cardId}")
    CardDbDto getCardById(@Param("cardId") Integer cardId);

    @Insert("insert into tarjeta (id, nro, venc, nombre, cliente_cliente_id, status, tx_id, tx_host, tx_date)" +
            "values (#{tarjetaId},#{nro},#{vencimiento},#{nombre},#{clientId},#{status},#{txId},#{txHost},#{txDate});")
    void createNewCard(CardDbDto cardDbDto );

    @Select("Select id as cardId, nro , venc as vencimiento,nombre,status,tx_id,tx_host,tx_date from tarjeta where cliente_cliente_id = #{clientId}")
    List<CardDbDto> getCardsByClient(@Param("clientId") Integer clientId);
}
