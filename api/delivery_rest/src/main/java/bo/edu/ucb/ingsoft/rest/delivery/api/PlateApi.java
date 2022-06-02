package bo.edu.ucb.ingsoft.rest.delivery.api;

import bo.edu.ucb.ingsoft.rest.delivery.bl.PlateBl;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.ClientApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.PlateApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.ClientDbDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.PlateDbDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/plate")
public class PlateApi {
    private PlateBl plateBl;

    public PlateApi(PlateBl plateBl){
        this.plateBl = plateBl;
    }

    @GetMapping(path ="/{plateId}",produces = APPLICATION_JSON_VALUE)
    public PlateApiDto findPlateById(@PathVariable("plateId") Integer plateId){
        return plateBl.findPlateById(plateId);
    }

    @PostMapping(path= "/", consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public PlateDbDto addPlate(@RequestBody PlateApiDto plate){
        return plateBl.creatNewPlate(plate);
    }


    @PutMapping(path = "/{plateId}",consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public PlateDbDto updatePlate(@RequestBody PlateApiDto plate, @PathVariable("plateId") Integer plateId) {
        return plateBl.updatePlate(plate, plateId);
    }

    @DeleteMapping(path = "/{plateId}",consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public PlateDbDto deletePlate(@RequestBody PlateApiDto plate, @PathVariable("plateId") Integer plateId) {
        return plateBl.deletePlate(plate, plateId);
    }

    @GetMapping(path ="/",produces = APPLICATION_JSON_VALUE)
    public List<PlateApiDto> findAllPlate(@RequestParam("category") Integer categoryId){
        return plateBl.findAllPlate(categoryId);
    }

}
