package app.repository;

import app.domain.Trust;
import app.domain.TrustPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrustRepository extends JpaRepository<Trust, TrustPK> {
}
