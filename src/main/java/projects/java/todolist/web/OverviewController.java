package projects.java.todolist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projects.java.todolist.application.service.TaskService;

import java.time.LocalDate;

@Controller
@RequestMapping("/overview")
public class OverviewController {

    private TaskService service;

    public OverviewController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public String overview(Model model) {
        model.addAttribute("tasksByDay", service.getTasksByDay());
        return "overview";
    }

    @PostMapping
    public String addTask(@RequestParam String taskName,
                          @RequestParam String taskTime,
                          @RequestParam LocalDate taskDate,
                          @RequestParam String taskDescription,
                          Model model) {
        service.createTask(taskName, taskDescription,taskTime,taskDate);
        model.addAttribute("tasksByDay", service.getTasksByDay());
        return "overview";
    }
}
