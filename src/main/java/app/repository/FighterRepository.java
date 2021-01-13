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
}
