package dhbw.leftlovers.angebotsservice.repository;

import dhbw.leftlovers.angebotsservice.entity.Angebot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AngebotRepository extends JpaRepository<Angebot,Long> {
    Optional<List<Angebot>> findByUser_Userid(long userid);
    Optional<List<Angebot>> findByTitelStartingWith(String titel);
    Optional<List<Angebot>> findByUser_UseridAndTitelStartingWith(long userid, String titel);
    Optional<List<Angebot>> findByUser_UseridAndTitelStartingWithAndKategorie_Kategorieid(long userid, String titel, long kategorieid);
    Optional<List<Angebot>> findByKategorie_Kategorieid(long kategorieid);
    Optional<List<Angebot>> findByKategorie_KategorieidAndTitelStartingWith(long kategorieid,String titel);
    Optional<List<Angebot>> findByUser_UseridAndKategorie_Kategorieid(long userid, long kategorieid);
    Optional<List<Angebot>> findByStandort_Longname(String longname);
    Optional<List<Angebot>> findByKategorie_KategorieidAndStandort_LongnameAndTitelStartingWith(long kategorieid, String longname, String titel);
    Optional<List<Angebot>> findByKategorie_KategorieidAndStandort_Longname(long kategorieid, String longname);
    Optional<List<Angebot>> findByStandort_LongnameAndTitelStartingWith(String longname, String titel);
}
