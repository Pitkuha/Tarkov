package app.repository;

import app.domain.Trader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TraderRepository extends JpaRepository<Trader, Long> {
    List<Trader> findByCallsign(String name);
}
