package dhbw.leftlovers.angebotsservice.controller;

import dhbw.leftlovers.angebotsservice.service.AngebotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AngebotsService")
public class KategorienServiceRestController {

    //value = "/{name}"  @PathVariable String name
    @RequestMapping(method=RequestMethod.GET, value ="/Kategorie" ,produces = "application/json")
    public String getKategorieList() {
        return "Greetings from Spring Boot!";
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
