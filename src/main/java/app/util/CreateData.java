package app.util;

import app.domain.Task;
import app.domain.Trader;
import app.repository.TaskRepository;
import app.repository.TraderRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CreateData {
    private final TraderRepository traderRepository;
    private final TaskRepository taskRepository;

    public CreateData(TraderRepository traderRepository, TaskRepository taskRepository) {
        this.traderRepository = traderRepository;
        this.taskRepository = taskRepository;
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
    }
}
