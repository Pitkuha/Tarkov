package app.util;

import app.domain.*;
import app.repository.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class CreateData {
    private final TraderRepository traderRepository;
    private final TaskRepository taskRepository;
    private final TraderTasksRepository traderTasksRepository;
    private final HelmetRepository helmetRepository;
    private final TraderInventoryRepository traderInventoryRepository;

    public CreateData(TraderRepository traderRepository, TaskRepository taskRepository, TraderTasksRepository traderTasksRepository, HelmetRepository helmetRepository, TraderInventoryRepository traderInventoryRepository) {
        this.traderRepository = traderRepository;
        this.taskRepository = taskRepository;
        this.traderTasksRepository = traderTasksRepository;
        this.helmetRepository = helmetRepository;
        this.traderInventoryRepository = traderInventoryRepository;
    }

    @PostConstruct
    public void addInTables(){
        taskRepository.save(new Task("А",10000,"А",1));
        taskRepository.save(new Task("Б",10000,"Б",1));
        taskRepository.save(new Task("В",10000,"В",2));
        taskRepository.save(new Task("Г",10000,"Г",3));
        taskRepository.save(new Task("Д",10000,"Д",4));

        traderRepository.save(new Trader("Prapor",600000));
        traderRepository.save(new Trader("Terapevt",600000));
        traderRepository.save(new Trader("Skupshik",600000));
        traderRepository.save(new Trader("Lizhnik",600000));
        traderRepository.save(new Trader("Mirotvorec",600000));
        traderRepository.save(new Trader("Mechanic",600000));
        traderRepository.save(new Trader("Baracholshik",600000));
        traderRepository.save(new Trader("Eger",600000));

        List<Trader> traders = traderRepository.findAll();
        List<Task> tasks = taskRepository.findAll();
        traders.stream().forEach((trader -> {
            tasks.stream().forEach((task -> {traderTasksRepository.save(new TraderTasks(trader,task));}));
        }));
        System.out.println("ready");

        helmetRepository.save(new Helmet("СШ-68",3,"Сталь",100,50));
        helmetRepository.save(new Helmet("Забрало-М",2,"Углеродный пластик",100,30));
        helmetRepository.save(new Helmet("Шлем Киллы",4,"Титан",100,70));

        List<Helmet> helmetList = helmetRepository.findAll();
        traderInventoryRepository.save(new TraderInventory(traders.get(0),null,null,null,null,null,null,helmetList.get(0),1000,10000));
        traderInventoryRepository.save(new TraderInventory(traders.get(0),null,null,null,null,null,null,helmetList.get(1),1000,5000));
        traderInventoryRepository.save(new TraderInventory(traders.get(0),null,null,null,null,null,null,helmetList.get(2),1000,20000));
    }
}
