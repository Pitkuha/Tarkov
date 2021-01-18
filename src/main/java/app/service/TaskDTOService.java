package app.service;

import app.domain.Task;
import app.domain.TraderTasks;
import app.repository.*;
import app.util.Tasks;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class TaskDTOService {

    //
    private final FighterRepository fighterRepository;
    private final TraderTasksRepository traderTasksRepository;
    private final TrustRepository trustRepository;
    private final TaskRepository taskRepository;

    public TaskDTOService(FighterRepository fighterRepository, TraderTasksRepository traderTasksRepository, TrustRepository trustRepository, TaskRepository taskRepository) {
        this.fighterRepository = fighterRepository;
        this.traderTasksRepository = traderTasksRepository;
        this.trustRepository = trustRepository;
        this.taskRepository = taskRepository;
    }

    public List<Tasks> getAllAvailableTasks(String name){
        List<Tasks> fromDB = traderTasksRepository.FindAllWithDescriptionQuery(name);
        return fromDB;
    }

    public String takeTask(TraderTasks request, String name){
        Task taskId = traderTasksRepository.findTask(request.getId());
        fighterRepository.updateCurrentTask(taskId, name);
        traderTasksRepository.deleteTraderTasksById(request.getId());
        return "Ok";
    }

    public boolean checkCurrentTask(String name){
        return fighterRepository.findByCallsign(name).get(0).getTask() == null;
    }

    public String passTask(String name, HttpServletResponse response) throws IOException {
        Task task = fighterRepository.findTask(name);
        if (task != null) {
            double reward = task.getReward();
            fighterRepository.updateMoney(name, reward);
            fighterRepository.updateTaskNull(name);
        } else {
            response.sendError(418,"У вас нету никаких тасков");
        }
        return "passTask() ok!";
    }

    public Task getCurrentTask(String name){
        return fighterRepository.findTask(name);
    }
}
