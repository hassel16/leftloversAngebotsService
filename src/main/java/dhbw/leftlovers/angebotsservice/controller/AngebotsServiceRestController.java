package dhbw.leftlovers.angebotsservice.controller;

import dhbw.leftlovers.angebotsservice.entity.Angebot;
import dhbw.leftlovers.angebotsservice.service.AngebotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/AngebotsService")
public class AngebotsServiceRestController {

    @Autowired
    AngebotsService angebotsService;

    @GetMapping(value ="/wakeup",produces = "application/json")
    public String wakeup() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping(value ="/Angebot",produces = "application/json")
    @ResponseBody public List<Angebot> getArticleList(@RequestParam(value = "userid") Optional<Long> userparameter,
                                                      @RequestParam(value = "angebotstitel") Optional<String> angebotstitel,
                                                      @RequestParam(value = "kategorieid") Optional<Long> kategorieparameter) {
        if(userparameter.isPresent() && angebotstitel.isPresent() && kategorieparameter.isPresent()){
            return angebotsService.findByUserIdAndTitelAndKategorieId(userparameter.get(),angebotstitel.get(),kategorieparameter.get()).orElse(new ArrayList<>());
        }else if(userparameter.isPresent() && angebotstitel.isPresent()){
            return angebotsService.findByUserIdAndTitel(userparameter.get(),angebotstitel.get()).orElse(new ArrayList<>());
        }else if (angebotstitel.isPresent() && kategorieparameter.isPresent()){
            return angebotsService.findByKategorieIdAndTitel(kategorieparameter.get(),angebotstitel.get()).orElse(new ArrayList<>());
        }else if (userparameter.isPresent() && kategorieparameter.isPresent()){
            return angebotsService.findByUserAndKategorieId(userparameter.get(),kategorieparameter.get()).orElse(new ArrayList<>());
        }else if(angebotstitel.isPresent()){
            return angebotsService.findByTitel(angebotstitel.get()).orElse(new ArrayList<>());
        }else if(userparameter.isPresent()){
            return angebotsService.findByUser(userparameter.get()).orElse(new ArrayList<>());
        }else if(kategorieparameter.isPresent()){
            return angebotsService.findByKategorieId(kategorieparameter.get()).orElse(new ArrayList<>());
        }
        return angebotsService.getAngebotlist();
    }

    @PostMapping(value = "/Angebot",produces = "application/json")
    @ResponseBody Angebot newAngebot(@RequestBody Angebot angebot) {
        return angebotsService.save(angebot);
    }

    @GetMapping(value ="/Angebot/{angebotsid}",produces = "application/json")
    @ResponseBody Angebot getAngebot(@PathVariable Long angebotsid) {
        if(angebotsService.getAngebot(angebotsid).isPresent()){
            return angebotsService.getAngebot(angebotsid).get();
        }else{
            return null;
        }
    }
}
