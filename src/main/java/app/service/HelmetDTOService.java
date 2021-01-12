package app.service;

import app.domain.Helmet;
import app.repository.HelmetRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HelmetDTOService {
    private final HelmetRepository helmetRepository;

    public HelmetDTOService(HelmetRepository helmetRepository) {
        this.helmetRepository = helmetRepository;
    }

    public void save(Helmet helmet){
        helmetRepository.save(helmet);
        System.out.println(helmet);
    }

    public List<Helmet> loadUsersDots() {
        List<Helmet> fromDB = helmetRepository.findAll();
        return fromDB;
    }

}
