package app.repository;

import app.domain.Trader;
import app.domain.TraderInventory;
import app.domain.TraderInventoryPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TraderInventoryRepository extends JpaRepository<TraderInventory, TraderInventoryPK> {
    List<TraderInventory> findAllByTraderId(Trader byId);

    @Transactional
    @Modifying
    @Query("update TraderInventory ti set ti.amount = ti.amount - :amount where ti.id = :id")
    void updateInventoryTrader(@Param("id") long id, @Param("amount") int amount);

    @Query("select t.traderId.id from TraderInventory t where t.id = :id")
    long findByTraderInvId(@Param("id") long traderInvId);

    @Query(value = "select * from Trader_Inventory t where t.id = ?", nativeQuery = true)
    TraderInventory findTI(long idTraderInventory);
}
