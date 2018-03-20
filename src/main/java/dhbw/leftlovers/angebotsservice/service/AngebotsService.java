package dhbw.leftlovers.angebotsservice.service;

import dhbw.leftlovers.angebotsservice.entity.Angebot;
import dhbw.leftlovers.angebotsservice.repository.AngebotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<Angebot> getAngebot(long angebotsid){
        return angebotRepository.findById(angebotsid);
    }

    @Override
    public Angebot save(Angebot newAngebot) {
        return angebotRepository.save(newAngebot);
    }

    @Override
    public Optional<List<Angebot>> findByUser(long userId) {
        return angebotRepository.findByUserid(userId);
    }
}
