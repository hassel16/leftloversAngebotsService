package dhbw.leftlovers.angebotsservice.repository;

import dhbw.leftlovers.angebotsservice.entity.Angebot;
import dhbw.leftlovers.angebotsservice.entity.Kategorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategorieRepository extends JpaRepository<Kategorie,Long> {
}
