package app.repository;

import app.domain.Magazin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazinRepository extends JpaRepository<Magazin, Long> {
}
