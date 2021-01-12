package app.service;

import app.domain.Dot;
import app.domain.DotDTO;
import app.profiling.LongMBean;
import app.repository.DotRepository;
import app.repository.UserRepository;
import app.util.DotManipulationBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DotDTOService {
    private final DotRepository dotRepository;
    private DotManipulationBean dotManipulationBean;
    private final UserRepository userRepository;
    private final LongMBean longMBean;

    public DotDTOService(DotRepository dotRepository, DotManipulationBean dotManipulationBean, UserRepository userRepository, LongMBean longMBean) {
        this.dotRepository = dotRepository;
        this.dotManipulationBean = dotManipulationBean;
        this.userRepository = userRepository;
        this.longMBean = longMBean;
    }

    public void save(DotDTO dots, String owner) {
        List<Dot> dotList = dotManipulationBean.dotListFromRequest(dots,owner);
        for (Dot d : dotList) {
            longMBean.incPoints(1);
            if (d.isResult() == true) longMBean.incPointsInArea(1);
            dotRepository.save(d);
            System.out.println(d);
        }

    }
    public List<DotDTO> loadUsersDots(String name) {
        List<Dot> fromDB = dotRepository.findAllByOwner(userRepository.findByUsername(name));
        List<DotDTO> toClient = new ArrayList<>();
        for (Dot d :
                fromDB) {
            toClient.add(new DotDTO(d));
        }
        return toClient;
    }
}
