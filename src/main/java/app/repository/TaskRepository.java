package app.repository;

import app.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.security.Principal;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "select * from Tasks a join trader_task b on a.id = b.task_id join Trader c on c.id = b.trader_id join Trust d on d.trader_id = c.id join Fighter e on d.fighter_id = e.id where d.trustlevel >= a.trustlevel", nativeQuery = true)
    List<Task> FindAllWithDescriptionQuery(String name);
}
