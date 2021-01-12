package app.service;

import app.domain.TraderInventory;
import app.repository.TraderInventoryRepository;
import app.repository.TraderRepository;

import java.util.List;

public class TraderDTOService {
    private final TraderRepository traderRepository;
    private final TraderInventoryRepository traderInventoryRepository;

    public TraderDTOService(TraderRepository traderRepository, TraderInventoryRepository traderInventoryRepository) {
        this.traderRepository = traderRepository;
        this.traderInventoryRepository = traderInventoryRepository;
    }

    public List<TraderInventory> getAllInventory(){
        List<TraderInventory>  fromDB = traderInventoryRepository.
    }
}
