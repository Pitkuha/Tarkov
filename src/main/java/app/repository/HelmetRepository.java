package app.repository;

import app.domain.Helmet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelmetRepository extends JpaRepository<Helmet, Long> {

}
