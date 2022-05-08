package bo.edu.ucb.ingsoft.deliverybot.delivery.bl;


import bo.edu.ucb.ingsoft.deliverybot.delivery.dao.ClientDao;
import bo.edu.ucb.ingsoft.deliverybot.delivery.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientBl {
    private ClientDao clienteDao;
    @Autowired
    public ClientBl(ClientDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    public ClientDto getClientData(long chatId){

        return clienteDao.getClientData(chatId);
    }
    public ClientDto createClientDto(String nombre, String nit, String telefono ,long chatId){
        ClientDto clientdto  = new ClientDto();
        clientdto.setCliente_id(clienteDao.getNextClientId());
        clientdto.setNombre(nombre);
        clientdto.setNit(nit);
        clientdto.setTelefono(telefono);
        clientdto.setChat_id(chatId);
        clientdto.setStatus(1);
        return clientdto;
    }

    public ClientDto createClientDto(int id,String nombre, String nit, String telefono ,long chatId){

        ClientDto clientdto  = new ClientDto();
        clientdto.setCliente_id(id);
        clientdto.setNombre(nombre);
        clientdto.setNit(nit);
        clientdto.setTelefono(telefono);
        clientdto.setChat_id(chatId);
        clientdto.setStatus(1);
        return clientdto;
    }



}
