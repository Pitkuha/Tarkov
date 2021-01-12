package app.repository;

import app.domain.Provision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvisionRepository extends JpaRepository<Provision, Long> {

}
