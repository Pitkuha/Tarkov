package app.service;

import app.domain.Task;
import app.domain.Trader;
import app.domain.TraderTasks;
import app.domain.Trust;
import app.repository.*;
import app.util.Tasks;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskDTOService {
    private final TaskRepository taskRepository;

    //
    private final TrustRepository trustRepository;
    private final FighterRepository fighterRepository;
    private final TraderRepository traderRepository;
    private final TraderTasksRepository traderTasksRepository;

    public TaskDTOService(TaskRepository taskRepository, TrustRepository trustRepository, FighterRepository fighterRepository, TraderRepository traderRepository, TraderTasksRepository traderTasksRepository) {
        this.taskRepository = taskRepository;
        this.trustRepository = trustRepository;
        this.fighterRepository = fighterRepository;
        this.traderRepository = traderRepository;
        this.traderTasksRepository = traderTasksRepository;
    }

    public List<Tasks> getAllAvailableTasks(String name){
//        traderRepository.save(new Trader("Prapor", 100000));
//        traderRepository.save(new Trader("Terapevt", 200000));
//        taskRepository.save(new Task("Убить Киллу", 100000, "Убить Киллу мазафака", 1));
//        taskRepository.save(new Task("Убить Билла", 120000, "Убить Билла мазафака", 2));
//        taskRepository.save(new Task("Убить Клима", 120000000, "Убить Клима мазафака", 4));
//        trustRepository.save(new Trust(fighterRepository.getOne(22L),traderRepository.getOne(23L),1));
//        trustRepository.save(new Trust(fighterRepository.getOne(22L),traderRepository.getOne(24L),2));
//        trustRepository.save(new Trust(fighterRepository.getOne(29L),traderRepository.getOne(23L),3));
//        trustRepository.save(new Trust(fighterRepository.getOne(29L),traderRepository.getOne(24L),4));
//        traderTasksRepository.save(new TraderTasks(traderRepository.getOne(23L),taskRepository.getOne(25L)));
//        traderTasksRepository.save(new TraderTasks(traderRepository.getOne(23L),taskRepository.getOne(26L)));
//        traderTasksRepository.save(new TraderTasks(traderRepository.getOne(24L),taskRepository.getOne(26L)));
//        traderTasksRepository.save(new TraderTasks(traderRepository.getOne(24L),taskRepository.getOne(27L)));
        List<Tasks> fromDB = traderTasksRepository.FindAllWithDescriptionQuery(name);
        return fromDB;
    }

    public String takeTask(TraderTasks request, String name){
        Task taskId = traderTasksRepository.FindTask(request.getId());
        System.out.println(taskId);
        fighterRepository.updateCurrentTask(taskId, name);
        traderTasksRepository.deleteTraderTasksById(request.getId());
        return "Ok";
    }

    public String passTask(String name){
        Task task = fighterRepository.findTask(name);
        double reward = task.getReward();
        fighterRepository.updateMoney(name,reward);
        return "passTask ok";
    }
}
