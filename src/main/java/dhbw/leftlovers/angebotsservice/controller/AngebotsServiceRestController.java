package dhbw.leftlovers.angebotsservice.controller;

import dhbw.leftlovers.angebotsservice.entity.Angebot;
import dhbw.leftlovers.angebotsservice.register.Health;
import dhbw.leftlovers.angebotsservice.service.angebotsservice.AngebotsService;
import dhbw.leftlovers.angebotsservice.service.standortservice.StandortService;
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

    @Autowired
    StandortService standortService;

    @GetMapping(value ="/health",produces = "application/json")
    @ResponseBody public Health wakeup() {
        return new Health();
    }

    @GetMapping(value ="/Angebot",produces = "application/json")
    @ResponseBody public List<Angebot> getArticleList(@RequestParam(value = "userid") Optional<Long> userparameter,
                                                      @RequestParam(value = "angebotstitel") Optional<String> angebotstitel,
                                                      @RequestParam(value = "kategorieid") Optional<Long> kategorieparameter,
                                                      @RequestParam(value = "long_name") Optional<String> long_name,
                                                      @RequestParam(value = "lat") Optional<Double> lat,
                                                      @RequestParam(value = "lng") Optional<Double> lng,
                                                      @RequestParam(value = "radius") Optional<Long> radius) {

        int mode = this.getArticleListMode(userparameter, angebotstitel, kategorieparameter,radius);
        List<Angebot> output;
        switch (mode){
            case 0 :
                output = angebotsService.getAngebotlist();
                break;
            case 1 :
                output = angebotsService.findByUserIdAndTitelAndKategorieId(userparameter.get(),angebotstitel.get(),kategorieparameter.get()).orElse(new ArrayList<>());
                break;
            case 2 :
                output = angebotsService.findByUserIdAndTitel(userparameter.get(),angebotstitel.get()).orElse(new ArrayList<>());
                break;
            case 3 :
                output = angebotsService.findByKategorieIdAndTitel(kategorieparameter.get(),angebotstitel.get()).orElse(new ArrayList<>());
                break;
            case 4 :
                output = angebotsService.findByUserAndKategorieId(userparameter.get(),kategorieparameter.get()).orElse(new ArrayList<>());
                break;
            case 5 :
                output = angebotsService.findByTitel(angebotstitel.get()).orElse(new ArrayList<>());
                break;
            case 6 :
                output = angebotsService.findByUser(userparameter.get()).orElse(new ArrayList<>());
                break;
            case 7 :
                output = angebotsService.findByKategorieId(kategorieparameter.get()).orElse(new ArrayList<>());
                break;
            case 8 :
                output = angebotsService.findByStandort_Longname(long_name.get()).orElse(new ArrayList<>());
                break;
            case 9 :
                output = angebotsService.findByKategorie_KategorieidAndStandort_LongnameAndTitelStartingWith(kategorieparameter.get(),long_name.get(),angebotstitel.get()).orElse(new ArrayList<>());
                break;
            case 10 :
                output = angebotsService.findByKategorie_KategorieidAndStandort_Longname(kategorieparameter.get(),long_name.get()).orElse(new ArrayList<>());
                break;
            case 11 :
                output = angebotsService.findByStandort_LongnameAndTitelStartingWith(long_name.get(),angebotstitel.get()).orElse(new ArrayList<>());
                break;
            default: output = new ArrayList<>();
        }

        if(lat.isPresent() && lng.isPresent()){
            if(radius.isPresent()){
                if(radius.get()>0 && lat.isPresent() && lng.isPresent()){
                    this.filterRadius(output,lng.get(),lat.get(),radius.get());
                }
            }else{
                output.stream().forEach(angebot-> angebot.setEntfernung(lat.get(),lng.get()));
            }
        }
        return output;
    }

    private void filterRadius(List<Angebot> angebotList,double lng, double lat, long radius){
        angebotList.removeIf((Angebot angebot) -> (angebot.isInRadius(lat,lng,radius)));
    }

    private int getArticleListMode(Optional<Long> userparameter,Optional<String> angebotstitel,Optional<Long> kategorieparameter,Optional<Long> radiusmode){
        if(radiusmode.isPresent()){
            if(radiusmode.get()==0){
                if(userparameter.isPresent() && angebotstitel.isPresent() && kategorieparameter.isPresent()){
                    return 1;
                }else if (angebotstitel.isPresent() && kategorieparameter.isPresent() && radiusmode.isPresent()) {
                    return 9;
                }else if(userparameter.isPresent() && angebotstitel.isPresent()){
                    return 2;
                }else if (angebotstitel.isPresent() && kategorieparameter.isPresent()){
                    return 3;
                }else if (userparameter.isPresent() && kategorieparameter.isPresent()){
                    return 4;
                }else if (kategorieparameter.isPresent() && radiusmode.isPresent()) {
                    return 10;
                }else if (angebotstitel.isPresent() && radiusmode.isPresent()) {
                    return 11;
                }else if(angebotstitel.isPresent()){
                    return 5;
                }else if(userparameter.isPresent()){
                    return 6;
                }else if(kategorieparameter.isPresent()){
                    return 7;
                }else if(radiusmode.isPresent()){
                    return 8;
                }
                return 0;
            }else{
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
        }else{
            return 0;
        }

    }

    @PostMapping(value = "/Angebot",produces = "application/json")
    @ResponseBody Angebot newAngebot(@RequestBody Angebot angebot) {
            standortService.findbylatlng(angebot.getCity().getLat(),angebot.getCity().getLng())
                    .ifPresent(standort -> angebot.setCity(standort));
        return angebotsService.save(angebot);
    }

    @PutMapping(value = "/Angebot",produces = "application/json")
    @ResponseBody Angebot updateAngebot(@RequestBody Angebot angebot) {
            standortService.findbylatlng(angebot.getCity().getLat(),angebot.getCity().getLng())
                    .ifPresent(standort -> angebot.setCity(standort));
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
