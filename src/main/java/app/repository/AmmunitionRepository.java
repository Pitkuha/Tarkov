package app.repository;

import app.domain.Ammunition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmmunitionRepository extends JpaRepository<Ammunition, Long> {
}
