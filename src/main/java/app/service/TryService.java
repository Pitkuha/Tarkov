package app.service;

import app.domain.TraderInventory;
import app.repository.TraderInventoryRepository;
import org.springframework.stereotype.Component;

@Component
public class TryService {
    private final TraderInventoryRepository traderInventoryRepository;

    public TryService(TraderInventoryRepository traderInventoryRepository) {
        this.traderInventoryRepository = traderInventoryRepository;
    }

    public void save(TraderInventory traderInventory){
        traderInventoryRepository.save(traderInventory);
        System.out.println("TraderInv");
    }
}
