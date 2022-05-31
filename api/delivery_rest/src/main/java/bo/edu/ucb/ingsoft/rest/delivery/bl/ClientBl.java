package bo.edu.ucb.ingsoft.rest.delivery.bl;

import bo.edu.ucb.ingsoft.rest.delivery.dao.ClientDao;
import bo.edu.ucb.ingsoft.rest.delivery.dao.SequenceDao;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.ClientApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.ClientDbDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ClientBl {
    private ClientDao clientDao;
    private SequenceDao sequenceDao;
    public Logger logger = LoggerFactory.getLogger(ClientBl.class);
    @Autowired
    public ClientBl(ClientDao clientDao, SequenceDao sequenceDao) {
        this.clientDao = clientDao;
        this.sequenceDao = sequenceDao;
    }

    public ClientApiDto findClientById(Integer clientId){
        ClientDbDto clientDbDto = clientDao.findClientById(clientId);
        logger.info(clientDbDto.toString());
        ClientApiDto clientApiDto = new ClientApiDto();
        clientApiDto.setClienteId(clientId);
        clientApiDto.setNombre(clientDbDto.getNombre());
        clientApiDto.setNit(clientDbDto.getNit());
        clientApiDto.setTelefono(clientDbDto.getTelefono());
        clientApiDto.setUsuario(clientDbDto.getUsuario());
        clientApiDto.setPassword(clientDbDto.getPassword());
        clientApiDto.setCorreo(clientDbDto.getCorreo());
        clientApiDto.setImagen(clientDbDto.getImagen());
        return clientApiDto;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public ClientDbDto creatNewClient(ClientApiDto newClient){
        ClientDbDto client = new ClientDbDto();
        client.setClientId(sequenceDao.getSequence(ClientDbDto.SEQUENCE_NAME));
        client.setNombre(newClient.getNombre());
        client.setNit(newClient.getNit());
        client.setUsuario(newClient.getUsuario());
        client.setPassword(newClient.getPassword());
        client.setTelefono(newClient.getTelefono());
        client.setCorreo(newClient.getCorreo());
        client.setImagen(newClient.getImagen());
        client.setStatus(1);
        client.setTxDate(new Date());
        client.setTxHost("localhost");
        client.setTxId(1);
        logger.debug(client.toString());
        clientDao.saveClient(client);
        return client;

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ClientDbDto updateClient(ClientApiDto newClient , int clientId){
        ClientDbDto client = new ClientDbDto();
        client.setClientId(clientId);
        client.setNombre(newClient.getNombre());
        client.setNit(newClient.getNit());
        client.setTelefono(newClient.getTelefono());
        client.setCorreo(newClient.getCorreo());
        client.setImagen(newClient.getImagen());
        client.setStatus(2);
        client.setTxDate(new Date());
        client.setTxHost("localhost");
        client.setTxId(1);
        logger.debug(client.toString());
        clientDao.updateClient(client);
        return client;
    }

}
