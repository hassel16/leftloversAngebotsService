package dhbw.leftlovers.angebotsservice.service;

import dhbw.leftlovers.angebotsservice.entity.Angebot;

import java.util.List;
import java.util.Optional;

public interface AngebotsServiceInterface {
    Angebot newAngebot(Angebot nAngebot);
    List<Angebot> getAngebotlist();
    Optional<Angebot> getAngebot(long angebotsid);
    Angebot save(Angebot newAngebot);
    Optional<List<Angebot>> findByUser(long userId);
}
