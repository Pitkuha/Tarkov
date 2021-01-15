package app.service;

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

    public TaskDTOService(TaskRepository taskRepository, TrustRepository trustRepository, FighterRepository fighterRepository, TraderRepository traderRepository, TraderTasksRepository traderTasksRepository, TraderInventoryRepository traderInventoryRepository, TraderRepository traderRepository1) {
        this.fighterRepository = fighterRepository;
        this.traderTasksRepository = traderTasksRepository;
        this.traderInventoryRepository = traderInventoryRepository;
        this.traderRepository = traderRepository1;
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
        return "passTask ok";
    }

    public Task getCurrentTask(String name){
        return fighterRepository.findTask(name);
    }

    public String buyItem(String name, TraderInventory traderInventory){
        traderInventoryRepository.updateInventory(traderInventory.getId(),traderInventory.getAmount());
        traderRepository.updateTraderMoney(traderInventory.getId(),traderInventory.getPrice() * traderInventory.getAmount());
        fighterRepository.updateMoneyAfterBuying(name,traderInventory.getPrice() * traderInventory.getAmount());
        if (fighterRepository.checkExists(fighterRepository.findByCallsign(name).get(0).getId()
                ,traderInventory.getAmmunition_id().getId()
                ,traderInventory.getArmor_id().getId()
                ,traderInventory.getHelmet_id().getId()
                ,traderInventory.getMagazine_id().getId()
                ,traderInventory.getMedicine_id().getId()
                ,traderInventory.getProvision_id().getId()
                ,traderInventory.getWeapon_id().getId()) == 0){

        } else {

        }

        return null;
    }
}
