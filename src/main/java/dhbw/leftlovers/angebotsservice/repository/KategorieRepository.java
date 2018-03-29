package dhbw.leftlovers.angebotsservice.repository;

import dhbw.leftlovers.angebotsservice.entity.Kategorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KategorieRepository extends JpaRepository<Kategorie,Long> {
    List<Kategorie> findAllByOrderByTitelAsc();
}
