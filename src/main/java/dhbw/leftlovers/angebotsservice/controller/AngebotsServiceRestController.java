package dhbw.leftlovers.angebotsservice.controller;

import dhbw.leftlovers.angebotsservice.entity.Angebot;
import dhbw.leftlovers.angebotsservice.register.Health;
import dhbw.leftlovers.angebotsservice.service.angebotsservice.AngebotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/AngebotsService")
public class AngebotsServiceRestController {

    @Autowired
    AngebotsService angebotsService;

    @GetMapping(value ="/health",produces = "application/json")
    @ResponseBody public Health wakeup() {
        return new Health();
    }

    @GetMapping(value ="/Angebot",produces = "application/json")
    @ResponseBody public List<Angebot> getArticleList(@RequestParam(value = "userid") Optional<Long> userparameter,
                                                      @RequestParam(value = "angebotstitel") Optional<String> angebotstitel,
                                                      @RequestParam(value = "kategorieid") Optional<Long> kategorieparameter) {
        int mode = this.getArticleListMode(userparameter, angebotstitel, kategorieparameter);
        switch (mode){
            case 0 : return angebotsService.getAngebotlist();
            case 1 : return angebotsService.findByUserIdAndTitelAndKategorieId(userparameter.get(),angebotstitel.get(),kategorieparameter.get()).orElse(new ArrayList<>());
            case 2 : return angebotsService.findByUserIdAndTitel(userparameter.get(),angebotstitel.get()).orElse(new ArrayList<>());
            case 3 : return angebotsService.findByKategorieIdAndTitel(kategorieparameter.get(),angebotstitel.get()).orElse(new ArrayList<>());
            case 4 : return angebotsService.findByUserAndKategorieId(userparameter.get(),kategorieparameter.get()).orElse(new ArrayList<>());
            case 5 : return angebotsService.findByTitel(angebotstitel.get()).orElse(new ArrayList<>());
            case 6 : return angebotsService.findByUser(userparameter.get()).orElse(new ArrayList<>());
            case 7 : return angebotsService.findByKategorieId(kategorieparameter.get()).orElse(new ArrayList<>());
            default: return new ArrayList<>();
        }
    }

    private int getArticleListMode(Optional<Long> userparameter,Optional<String> angebotstitel,Optional<Long> kategorieparameter){
        if(userparameter.isPresent() && angebotstitel.isPresent() && kategorieparameter.isPresent()){
            return 1;
        }else if(userparameter.isPresent() && angebotstitel.isPresent()){
            return 2;
        }else if (angebotstitel.isPresent() && kategorieparameter.isPresent()){
            return 3;
        }else if (userparameter.isPresent() && kategorieparameter.isPresent()){
            return 4;
        }else if(angebotstitel.isPresent()){
            return 5;
        }else if(userparameter.isPresent()){
            return 6;
        }else if(kategorieparameter.isPresent()){
            return 7;
        }
        return 0;
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

    @DeleteMapping(value ="/Angebot/{angebotsid}",produces = "application/json")
    @ResponseBody ResponseEntity deleteAngebot(@PathVariable Long angebotsid){
        this.angebotsService.deleteAngebot(angebotsid);
        return this.angebotsService.findByKategorieId(angebotsid).isPresent() ? ResponseEntity.status(500).body(null) :  ResponseEntity.accepted().body(null);
    }
}
