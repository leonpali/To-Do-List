package projects.java.todolist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.java.todolist.application.service.TaskService;

@Controller
@RequestMapping("/details")
public class DetailsController {

    private TaskService service;

    public DetailsController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String details(@PathVariable int id) {
        return "details";
    }

    @PostMapping("/{id}/done")
    public String done(@PathVariable int id) {
        service.finishTask(id);
        return "redirect:/overview";
    }

    @PostMapping("/{id}/useTime")
    public String useTime(@PathVariable int id) {
        return "details";
    }
}
