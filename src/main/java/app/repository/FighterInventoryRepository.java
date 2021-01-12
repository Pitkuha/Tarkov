package app.repository;

import app.domain.FighterInventory;
import app.domain.FighterInventoryPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FighterInventoryRepository extends JpaRepository<FighterInventory, FighterInventoryPK> {
}
