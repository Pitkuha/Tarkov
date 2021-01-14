package app.repository;

import app.domain.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TraderRepository extends JpaRepository<Trader, Long> {
    List<Trader> findByCallsign(String name);

    @Transactional
    @Modifying
    @Query("update Trader t set t.money = t.money + :money where t.id = :id")
    void updateTraderMoney(@Param("id") long id, @Param("money") double money);
}
