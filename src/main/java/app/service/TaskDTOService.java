package app.service;

import app.domain.FighterInventory;
import app.domain.Task;
import app.domain.TraderInventory;
import app.domain.TraderTasks;
import app.repository.*;
import app.util.Tasks;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskDTOService {

    //
    private final FighterRepository fighterRepository;
    private final TraderTasksRepository traderTasksRepository;
    private final TraderInventoryRepository traderInventoryRepository;
    private final TraderRepository traderRepository;
    private final FighterInventoryRepository fighterInventoryRepository;
    private final HelmetRepository helmetRepository;

    public TaskDTOService(TaskRepository taskRepository, TrustRepository trustRepository, FighterRepository fighterRepository, TraderRepository traderRepository, TraderTasksRepository traderTasksRepository, TraderInventoryRepository traderInventoryRepository, TraderRepository traderRepository1, FighterInventoryRepository fighterInventoryRepository, HelmetRepository helmetRepository) {
        this.fighterRepository = fighterRepository;
        this.traderTasksRepository = traderTasksRepository;
        this.traderInventoryRepository = traderInventoryRepository;
        this.traderRepository = traderRepository1;
        this.fighterInventoryRepository = fighterInventoryRepository;
        this.helmetRepository = helmetRepository;
    }

    public List<Tasks> getAllAvailableTasks(String name){
//        taskRepository.save(new Task("Убить Киллу", 100000, "Убить Киллу мазафака", 1));
//        taskRepository.save(new Task("Убить Билла", 120000, "Убить Билла мазафака", 2));
//        taskRepository.save(new Task("Убить Клима", 120000000, "Убить Клима мазафака", 4));
//        trustRepository.save(new Trust(fighterRepository.getOne(636L),traderRepository.getOne(624L),1));
//        trustRepository.save(new Trust(fighterRepository.getOne(636L),traderRepository.getOne(625L),2));
//        trustRepository.save(new Trust(fighterRepository.getOne(641L),traderRepository.getOne(624L),3));
//        trustRepository.save(new Trust(fighterRepository.getOne(641L),traderRepository.getOne(625L),4));
//        traderTasksRepository.save(new TraderTasks(traderRepository.getOne(624L),taskRepository.getOne(642L)));
//        traderTasksRepository.save(new TraderTasks(traderRepository.getOne(624L),taskRepository.getOne(643L)));
//        traderTasksRepository.save(new TraderTasks(traderRepository.getOne(625L),taskRepository.getOne(643L)));
//        traderTasksRepository.save(new TraderTasks(traderRepository.getOne(625L),taskRepository.getOne(644L)));
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

    public String passTask(String name){
        Task task = fighterRepository.findTask(name);
        double reward = task.getReward();
        fighterRepository.updateMoney(name,reward);
        fighterRepository.updateTaskNull(name);
        return "passTask() ok!";
    }

    public Task getCurrentTask(String name){
        //Добавить товар в инвентарь торговца
        //traderInventoryRepository.save(new TraderInventory(traderRepository.findById(624L).get(),null,null,null,null,null,null,helmetRepository.findById(604L).get(),10000,5000));
        return fighterRepository.findTask(name);
    }
}
