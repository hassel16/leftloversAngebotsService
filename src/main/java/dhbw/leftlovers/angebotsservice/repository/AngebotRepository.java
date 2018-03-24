package dhbw.leftlovers.angebotsservice.repository;

import dhbw.leftlovers.angebotsservice.entity.Angebot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AngebotRepository extends JpaRepository<Angebot,Long> {
    Optional<List<Angebot>> findByUserid(long userid);
    Optional<List<Angebot>> findByTitelStartingWith(String titel);
    Optional<List<Angebot>> findByUseridAndTitelStartingWith(long userid, String titel);
    Optional<List<Angebot>> findByUseridAndTitelStartingWithAndKategorie_Kategorieid(long userid, String titel,long kategorieid);
    Optional<List<Angebot>> findByKategorie_Kategorieid(long kategorieid);
    Optional<List<Angebot>> findByKategorie_KategorieidAndTitelStartingWith(long kategorieid,String titel);
    Optional<List<Angebot>> findByUseridAndKategorie_Kategorieid(long userid,long kategorieid);
}
