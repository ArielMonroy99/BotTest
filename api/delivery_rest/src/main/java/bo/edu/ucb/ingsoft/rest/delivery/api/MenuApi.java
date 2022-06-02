package bo.edu.ucb.ingsoft.rest.delivery.api;

import bo.edu.ucb.ingsoft.rest.delivery.bl.CategoryBl;
import bo.edu.ucb.ingsoft.rest.delivery.bl.MenuBl;
import bo.edu.ucb.ingsoft.rest.delivery.bl.PlateBl;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.CardApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.CategoryApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.ClientApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.api.PlateApiDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.ClientDbDto;
import bo.edu.ucb.ingsoft.rest.delivery.dto.db.PlateDbDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import java.util.List;

@RestController
@RequestMapping("/api/v1/menu")
public class MenuApi {
    private MenuBl menuBl;
    private CategoryBl categoryBl;

    public MenuApi(MenuBl menuBl, CategoryBl categoryBl){this.menuBl = menuBl; this.categoryBl = categoryBl;}

    @GetMapping(path ="/soups",produces = APPLICATION_JSON_VALUE)
    public List<PlateApiDto> allSoups(@RequestParam(value = "pageSize",required = false)Integer pageSize,
                                      @RequestParam(value = "pageNumber", required = false)Integer pageNumber){
        return menuBl.allSoups(pageSize,pageNumber);
    }

    @GetMapping(path ="/mains",produces = APPLICATION_JSON_VALUE)
    public List<PlateApiDto> allMains(@RequestParam(value = "pageSize",required = false)Integer pageSize,
                                      @RequestParam(value = "pageNumber",required = false)Integer pageNumber){
        return menuBl.allMains(pageSize,pageNumber);
    }

    @GetMapping(path ="/desserts",produces = APPLICATION_JSON_VALUE)
    public List<PlateApiDto> allDesserts(@RequestParam(value = "pageSize",required = false)Integer pageSize,
                                         @RequestParam(value = "pageNumber",required = false)Integer pageNumber){
        return menuBl.allDesserts(pageSize,pageNumber);
    }

    @GetMapping(path ="/categories",produces = APPLICATION_JSON_VALUE)
    public List<CategoryApiDto> allCategories(){
        return categoryBl.allCategories();
    }

}
