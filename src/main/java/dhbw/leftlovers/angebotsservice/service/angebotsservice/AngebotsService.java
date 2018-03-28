package dhbw.leftlovers.angebotsservice.service.angebotsservice;

import dhbw.leftlovers.angebotsservice.entity.Angebot;
import dhbw.leftlovers.angebotsservice.repository.AngebotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AngebotsService implements  AngebotsServiceInterface{

    @Autowired
    AngebotRepository angebotRepository;

    public Angebot newAngebot(Angebot nAngebot){
        return angebotRepository.save(nAngebot);
    }

    public List<Angebot> getAngebotlist(){
        return angebotRepository.findAll();
    }

    @Override
    public Optional<Angebot> getAngebot(long angebotsid){
        return angebotRepository.findById(angebotsid);
    }

    @Override
    public Optional<List<Angebot>> findByTitel(String titel) {
        return angebotRepository.findByTitelStartingWith(titel);
    }

    public Optional<List<Angebot>> findByUserIdAndTitel(long userid, String titel) {
        return angebotRepository.findByUser_UseridAndTitelStartingWith(userid,titel);
    }

    public Optional<List<Angebot>> findByUserIdAndTitelAndKategorieId(long userid, String titel, long kategorieid) {
        return angebotRepository.findByUser_UseridAndTitelStartingWithAndKategorie_Kategorieid(userid,titel,kategorieid);
    }

    public Optional<List<Angebot>> findByKategorieIdAndTitel(long kategorieid, String titel) {
        return angebotRepository.findByKategorie_KategorieidAndTitelStartingWith(kategorieid, titel);
    }

    public Optional<List<Angebot>> findByUserAndKategorieId(long userid,long kategorieid) {
        return angebotRepository.findByUser_UseridAndKategorie_Kategorieid(userid,kategorieid);
    }

    public Optional<List<Angebot>> findByKategorieId(long kategorieid) {
        return angebotRepository.findByKategorie_Kategorieid(kategorieid);
    }

    @Override
    public Angebot save(Angebot newAngebot) {
        return angebotRepository.save(newAngebot);
    }

    @Override
    public Optional<List<Angebot>> findByUser(long userId) {
        return angebotRepository.findByUser_Userid(userId);
    }

    @Transactional
    public void deleteAngebot(long angebotsid){
        this.angebotRepository.deleteById(angebotsid);
    }
}
