package app.repository;

import app.domain.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FighterRepository extends JpaRepository<Fighter, Long> {
    List<Fighter> findByCallsign(String name);
}
