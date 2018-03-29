package dhbw.leftlovers.angebotsservice.service.standortservice;

import dhbw.leftlovers.angebotsservice.entity.Standort;
import dhbw.leftlovers.angebotsservice.repository.StandortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StandortService implements StandortServiceInterface {

    @Autowired
    StandortRepository standortRepository;

    public Optional<Standort> findbylatlng(double lat, double lng){
        return standortRepository.findByLatAndLng(lat,lng);
    }

}
