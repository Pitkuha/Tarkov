package app.service;

import app.domain.Fighter;
import app.domain.FighterInventory;
import app.domain.UserDTO;
import app.repository.FighterInventoryRepository;
import app.repository.FighterRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FighterDTOService {
    private final FighterInventoryRepository fighterInventoryRepository;
    private final FighterRepository fighterRepository;

    public FighterDTOService(FighterInventoryRepository fighterInventoryRepository, FighterRepository fighterRepository) {
        this.fighterInventoryRepository = fighterInventoryRepository;
        this.fighterRepository = fighterRepository;
    }

    public List<FighterInventory> getAllInventory(String name){
        List<FighterInventory> fromDB = fighterInventoryRepository.getAllByFighterId(fighterRepository.findByCallsign(name).get(0));
        return fromDB;
    }

    public Fighter addFighter(UserDTO userdata){
        Fighter fighter = new Fighter();
        fighter.setCallsign(userdata.getUsername());
        fighter.setMoney(400000);
        fighter.setTask(null);
        fighterRepository.save(fighter);
        return fighter;
    }
}


