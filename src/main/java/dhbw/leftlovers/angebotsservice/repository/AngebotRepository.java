package dhbw.leftlovers.angebotsservice.repository;

import dhbw.leftlovers.angebotsservice.entity.Angebot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AngebotRepository extends JpaRepository<Angebot,Long> {
    Optional<List<Angebot>> findByUserid(long userid);
}
