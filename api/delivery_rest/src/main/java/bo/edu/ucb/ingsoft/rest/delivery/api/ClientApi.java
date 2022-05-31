package bo.edu.ucb.ingsoft.rest.delivery.api;

import bo.edu.ucb.ingsoft.rest.delivery.bl.ClientBl;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.ClientApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.ClientDbDto;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/client")
public class ClientApi {
    private ClientBl clientBl;

    public ClientApi(ClientBl clientBl){
        this.clientBl = clientBl;
    }

    @GetMapping(path ="/{clientId}",produces = APPLICATION_JSON_VALUE)
    public ClientApiDto findPersonById(@PathVariable("clientId") Integer clientId){
        return clientBl.findClientById(clientId);
    }
    @PostMapping(path= "/", consumes = APPLICATION_JSON_VALUE,
    produces = APPLICATION_JSON_VALUE)
    public ClientDbDto saveClient(@RequestBody ClientApiDto cliente){
     return clientBl.creatNewClient(cliente);
    }

    @PutMapping(path="/{clientId}", consumes = APPLICATION_JSON_VALUE,produces = APPLICATION_JSON_VALUE)
    public ClientDbDto updateClient(@RequestBody ClientApiDto cliente,@PathVariable("clientId") Integer clientId) {
        return clientBl.updateClient(cliente,clientId);
    }
}
