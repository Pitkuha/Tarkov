package app.repository;

import app.domain.Armor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmorRepository extends JpaRepository<Armor, Long> {
}
