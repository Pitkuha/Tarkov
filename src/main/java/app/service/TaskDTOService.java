package app.service;

import app.domain.Task;
import app.domain.Trust;
import app.repository.FighterRepository;
import app.repository.TaskRepository;
import app.repository.TraderRepository;
import app.repository.TrustRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskDTOService {
    private final TaskRepository taskRepository;

    //
    private final TrustRepository trustRepository;
    private final FighterRepository fighterRepository;
    private final TraderRepository traderRepository;

    public TaskDTOService(TaskRepository taskRepository, TrustRepository trustRepository, FighterRepository fighterRepository, TraderRepository traderRepository) {
        this.taskRepository = taskRepository;
        this.trustRepository = trustRepository;
        this.fighterRepository = fighterRepository;
        this.traderRepository = traderRepository;
    }

    public List<Task> getAllAvailableTasks(String name){
        taskRepository.save(new Task("Убить Киллу", 100000, "Убить Киллу мазафака", 1));
        taskRepository.save(new Task("Убить Билла", 120000, "Убить Билла мазафака", 2));
        taskRepository.save(new Task("Убить Клима", 120000000, "Убить Клима мазафака", 4));
        trustRepository.save(new Trust(fighterRepository.getOne(636L),traderRepository.getOne(624L),1));
        trustRepository.save(new Trust(fighterRepository.getOne(636L),traderRepository.getOne(625L),2));
        trustRepository.save(new Trust(fighterRepository.getOne(641L),traderRepository.getOne(624L),3));
        trustRepository.save(new Trust(fighterRepository.getOne(641L),traderRepository.getOne(625L),4));

        List<Task> fromDB = taskRepository.FindAllWithDescriptionQuery(name);
        return fromDB;
    }
}
