package app.repository;

import app.domain.Dot;
import app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DotRepository extends JpaRepository<Dot, Long> {
    List<Dot> findAllByOwner(User byUsername);
}
