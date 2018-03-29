package dhbw.leftlovers.angebotsservice.service.angebotsservice;

import dhbw.leftlovers.angebotsservice.entity.Angebot;

import java.util.List;
import java.util.Optional;

public interface AngebotsServiceInterface {
    Angebot newAngebot(Angebot nAngebot);
    Angebot save(Angebot newAngebot);
    List<Angebot> getAngebotlist();
    Optional<Angebot> getAngebot(long angebotsid);
    Optional<List<Angebot>> findByTitel(String titel);
    Optional<List<Angebot>> findByUser(long userId);
    Optional<List<Angebot>> findByUserIdAndTitel(long userid, String titel);
    Optional<List<Angebot>> findByUserIdAndTitelAndKategorieId(long userid, String titel, long kategorieid);
    Optional<List<Angebot>> findByKategorieIdAndTitel(long kategorieid, String titel);
    Optional<List<Angebot>> findByUserAndKategorieId(long kategorieid, long userid);
    Optional<List<Angebot>> findByStandort_Longname(String longname);
    Optional<List<Angebot>> findByKategorie_KategorieidAndStandort_LongnameAndTitelStartingWith(long kategorieid, String longname, String titel);
    Optional<List<Angebot>> findByKategorie_KategorieidAndStandort_Longname(long kategorieid, String longname);
    Optional<List<Angebot>> findByStandort_LongnameAndTitelStartingWith(String longname, String titel);
}
