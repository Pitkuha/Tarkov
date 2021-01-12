package app.repository;

import app.domain.TraderInventory;
import app.domain.TraderInventoryPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraderInventoryRepository extends JpaRepository<TraderInventory, TraderInventoryPK> {
}
