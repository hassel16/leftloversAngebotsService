package dhbw.leftlovers.angebotsservice.controller;

import dhbw.leftlovers.angebotsservice.entity.Kategorie;
import dhbw.leftlovers.angebotsservice.service.kategorieservice.KategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AngebotsService")
public class KategorienServiceRestController {

    @Autowired
    KategorieService kategorieService;

    //value = "/{name}"  @PathVariable String name
    @RequestMapping(method=RequestMethod.GET, value ="/Kategorie" ,produces = "application/json")
    @ResponseBody public List<Kategorie> getKategorieList() {
        return kategorieService.getKategorieList();
    }

    //value = "/{name}"  @PathVariable String name
    @RequestMapping(method=RequestMethod.POST, value ="/Kategorie" ,produces = "application/json")
    public String newKategorie() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(method= RequestMethod.GET, value ="/Kategorie/{kategorieid}",produces = "application/json")
    public String index5(@PathVariable Long angebotsid) {

        return "Greetings from Spring Boot!";
    }
}
