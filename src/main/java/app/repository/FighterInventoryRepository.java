package app.repository;

import app.domain.Fighter;
import app.domain.FighterInventory;
import app.domain.FighterInventoryPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FighterInventoryRepository extends JpaRepository<FighterInventory, FighterInventoryPK> {
    List<FighterInventory> getAllByFighterId(Fighter byId);
}
