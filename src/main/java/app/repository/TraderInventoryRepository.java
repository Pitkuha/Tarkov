package app.repository;

import app.domain.Trader;
import app.domain.TraderInventory;
import app.domain.TraderInventoryPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TraderInventoryRepository extends JpaRepository<TraderInventory, TraderInventoryPK> {
    List<TraderInventory> findAllByTraderId(Trader byId);
}
