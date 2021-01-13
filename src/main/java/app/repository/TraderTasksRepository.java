package app.repository;

import app.domain.Task;
import app.domain.TraderTasks;
import app.domain.TraderTasksPK;
import app.util.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TraderTasksRepository extends JpaRepository<TraderTasks, TraderTasksPK> {
    @Query(value = "select distinct a.name as Name, b.Id as Id, a.description as Description, a.reward as Reward, c.callsign as CallSign from Tasks a join trader_tasks b on a.id = b.task_id join Trader c on c.id = b.trader_id join Trust d on d.trader_id = c.id join Fighter e on d.fighter_id = e.id where d.trust_level >= a.trust_level and e.callsign = ?", nativeQuery = true)
    List<Tasks> FindAllWithDescriptionQuery(String name);

    @Query("select tt.task from TraderTasks tt where tt.id  = :traderTaskId")
    Task FindTask(@Param("traderTaskId") long traderTaskId);
}
