package dhbw.leftlovers.angebotsservice.controller;

import dhbw.leftlovers.angebotsservice.entity.Angebot;
import dhbw.leftlovers.angebotsservice.service.AngebotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AngebotsService")
public class AngebotsServiceRestController {

    @Autowired
    AngebotsService angebotsService;

    @RequestMapping(method=RequestMethod.GET, value = "/wakeup", produces = "application/json")
    public String wakeup() {
        return "Greetings from Spring Boot!";
    }

    //value = "/{name}"  @PathVariable String name
    @RequestMapping(method=RequestMethod.GET, value ="/Angebot" ,produces = "application/json")
    @ResponseBody public List<Angebot> getArticleList() {
        return angebotsService.getAngebotlist();
    }

    @RequestMapping(method= RequestMethod.POST, value ="/Angebot",produces = "application/json")
    public String newAngebot(@RequestBody Angebot angebot) {
        return "sadad";
    }

    @RequestMapping(method= RequestMethod.GET, value ="/Angebot/{angebotsid}",produces = "application/json")
    @ResponseBody Angebot getAngebot(@PathVariable Long angebotsid) {
        if(angebotsService.getAngebot(angebotsid).isPresent()){
            return angebotsService.getAngebot(angebotsid).get();
        }else{
            return null;
        }
    }
}