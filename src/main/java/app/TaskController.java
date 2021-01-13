package app;

import app.domain.Task;
import app.service.TaskDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskDTOService taskDTOService;

    @GetMapping("/GetTasks")
    public List<Task> getTasks(Principal principal){
        return taskDTOService.getAllAvailableTasks(principal.getName());
    }
}
