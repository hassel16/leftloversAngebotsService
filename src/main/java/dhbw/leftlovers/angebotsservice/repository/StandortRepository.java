package dhbw.leftlovers.angebotsservice.repository;

import dhbw.leftlovers.angebotsservice.entity.Standort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StandortRepository extends JpaRepository<Standort,Long> {
    Optional<Standort> findByLatAndLng(double lat,double Lng);
}
