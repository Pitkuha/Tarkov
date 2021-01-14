package app.repository;

import app.domain.Fighter;
import app.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface FighterRepository extends JpaRepository<Fighter, Long> {
    List<Fighter> findByCallsign(String name);

    @Transactional
    @Modifying
    @Query("update Fighter f set f.task = :taskid where f.callsign = :callsign")
    void updateCurrentTask(@Param("taskid") Task task_id , @Param("callsign") String name);

    @Query("select f.task from Fighter f where f.callsign = :name")
    Task findTask(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("update Fighter f set f.task = null, f.money = f.money + :reward where f.callsign = :name")
    void updateMoney(@Param("name") String name, @Param("reward") double reward);

    @Transactional
    @Modifying
    @Query("update Fighter f set f.task = null where f.task = :taskId")
    void updateTaskNull (@Param("taskId") long taskId);

}
