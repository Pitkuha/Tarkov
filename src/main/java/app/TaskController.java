package app;

import app.domain.Task;
import app.domain.TraderTasks;
import app.service.TaskDTOService;
import app.util.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskDTOService taskDTOService;


    @GetMapping("/GetTasks")
    public List<Tasks> getTasks(Principal principal){
        return taskDTOService.getAllAvailableTasks(principal.getName());
    }

    @PostMapping(value = "/takeTask", produces = "application/json")
    public String takeTask(@Valid @RequestBody TraderTasks request, Principal principal){
        taskDTOService.takeTask(request,principal.getName());
        return "ok";
    }

    @PostMapping(value = "/passTask", produces = "application/json")
    public String passTask(Principal principal){
        taskDTOService.passTask(principal.getName());
        return "ok";
    }
}
