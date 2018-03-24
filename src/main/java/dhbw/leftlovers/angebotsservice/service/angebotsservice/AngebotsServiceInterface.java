package dhbw.leftlovers.angebotsservice.service;

import dhbw.leftlovers.angebotsservice.entity.Angebot;

import java.util.List;
import java.util.Optional;

public interface AngebotsServiceInterface {
    Angebot newAngebot(Angebot nAngebot);
    List<Angebot> getAngebotlist();
    Optional<Angebot> getAngebot(long angebotsid);
    Optional<List<Angebot>> findByTitel(String titel);
    Angebot save(Angebot newAngebot);
    Optional<List<Angebot>> findByUser(long userId);
    Optional<List<Angebot>> findByUserIdAndTitel(long userid, String titel);
    Optional<List<Angebot>> findByUserIdAndTitelAndKategorieId(long userid, String titel, long kategorieid);
    Optional<List<Angebot>> findByKategorieIdAndTitel(long kategorieid, String titel);
    Optional<List<Angebot>> findByUserAndKategorieId(long kategorieid, long userid);

}
