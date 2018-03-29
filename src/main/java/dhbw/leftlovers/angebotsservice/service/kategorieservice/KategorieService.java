package dhbw.leftlovers.angebotsservice.service.kategorieservice;

import dhbw.leftlovers.angebotsservice.entity.Kategorie;
import dhbw.leftlovers.angebotsservice.repository.KategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategorieService implements KategorieServiceInterface {

    @Autowired
    KategorieRepository kategorieRepository;

    @Override
    public List<Kategorie> getKategorieList() {
        return kategorieRepository.findAllByOrderByTitelAsc();
    }
}
