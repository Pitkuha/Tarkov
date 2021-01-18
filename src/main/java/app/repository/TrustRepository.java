package app.repository;

import app.domain.Fighter;
import app.domain.Trader;
import app.domain.Trust;
import app.domain.TrustPK;
import app.util.Trusts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TrustRepository extends JpaRepository<Trust, TrustPK> {
    @Transactional
    @Modifying
    @Query("update Trust t set t.trust_level = t.trust_level + 1 where t.fighter_id = :fighter and t.trader_id = :trader")
    void updateTrust(@Param("trader") Trader trader,@Param("fighter") Fighter fighter);

    @Query("select t.trust_level from Trust t where t.trader_id = :trader and t.fighter_id = :fighter")
    int checkTrustLvl(@Param("trader") Trader trader, @Param("fighter") Fighter fighter);

    @Query("select t.trader_id.callsign as name, t.trust_level as trustLvl from Trust t where t.fighter_id = :fighter")
    List<Trusts> getTrusts(@Param("fighter") Fighter fighter);
}
