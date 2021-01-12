package app.service;

import app.domain.Trader;
import app.domain.TraderInventory;
import app.repository.TraderInventoryRepository;
import app.repository.TraderRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TraderDTOService {
    private final TraderRepository traderRepository;
    private final TraderInventoryRepository traderInventoryRepository;

    public TraderDTOService(TraderRepository traderRepository, TraderInventoryRepository traderInventoryRepository) {
        this.traderRepository = traderRepository;
        this.traderInventoryRepository = traderInventoryRepository;
    }

    public List<TraderInventory> getAllInventory(String name){
        List<TraderInventory>  fromDB = traderInventoryRepository.findAllByTraderId(traderRepository.findByCallsign(name).get(0));
        return fromDB;
    }
}
