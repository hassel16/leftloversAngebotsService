package dhbw.leftlovers.angebotsservice.repository;

import dhbw.leftlovers.angebotsservice.entity.Angebot;
import dhbw.leftlovers.angebotsservice.entity.Foto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FotoRepository extends JpaRepository<Foto,Long> {
}
