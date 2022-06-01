package bo.edu.ucb.ingsoft.rest.delivery.api;

import bo.edu.ucb.ingsoft.rest.delivery.bl.ClientBl;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.ClientApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.ImageDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.ClientDbDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/client")
public class ClientApi {
    private ClientBl clientBl;
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientApi.class);
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
    @PostMapping(path="/{clientId}/image")
    public String uploadImage(@RequestParam("archivo")MultipartFile archivo,@PathVariable Integer clientId){
        LOGGER.info("Recibiendo archivo: Formato: {},name: {},nombre original: {}",archivo.getContentType(),
                archivo.getName(),archivo.getOriginalFilename());
        return clientBl.savePhoto(archivo,clientId);
    }
    @RequestMapping(path = "/{clientId}/image",method = RequestMethod.GET)
    public ResponseEntity<Resource> getImage(@PathVariable("clientId") Integer clientId){
        ImageDto image = clientBl.getImage(clientId);
        File file = new File("E:\\IngSoftware\\image_test\\"+image.getImagen());
        InputStreamResource resource = null;
        try{
            resource = new InputStreamResource(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No se encontro el arvchivo");
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type",image.getImagenFormato());
        LOGGER.info("Fomato: {}",image.getImagenFormato());
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentLength(file.length())
                .body(resource);
    }
}
