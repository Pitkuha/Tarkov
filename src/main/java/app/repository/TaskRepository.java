package app.repository;

import app.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.security.Principal;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
