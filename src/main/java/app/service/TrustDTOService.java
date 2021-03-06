package app.service;

import app.domain.Fighter;
import app.domain.Trader;
import app.domain.Trust;
import app.repository.FighterRepository;
import app.repository.TraderRepository;
import app.repository.TrustRepository;
import app.util.Trusts;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Iterator;
import java.util.List;

@Component
public class TrustDTOService {
    private final TraderRepository traderRepository;
    private final FighterRepository fighterRepository;
    private final TrustRepository trustRepository;

    public TrustDTOService(TraderRepository traderRepository, FighterRepository fighterRepository, TrustRepository trustRepository) {
        this.traderRepository = traderRepository;
        this.fighterRepository = fighterRepository;
        this.trustRepository = trustRepository;
    }

    public void creatingTrusts(String name){
        Fighter fighter = fighterRepository.findByCallsign(name).get(0);
        List<Trader> traders = traderRepository.findAll();
        Iterator<Trader> traderIterator = traders.iterator();
        while (traderIterator.hasNext()){
            trustRepository.save(new Trust(fighter,traderIterator.next(),1));
        }
        System.out.println("Траст для трейдера создан");
    }

    public List<Trusts> getTrusts(String name){
        return trustRepository.getTrusts(fighterRepository.findByCallsign(name).get(0));
    }
}
