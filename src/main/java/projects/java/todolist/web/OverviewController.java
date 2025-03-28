package projects.java.todolist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/overview")
public class OverviewController {

    @GetMapping
    public String overview() {
        return "overview";
    }

    @PostMapping
    public String addTask(@RequestParam String taskName,
                          @RequestParam String taskTime,
                          @RequestParam LocalDate taskDate,
                          @RequestParam String taskDescription,
                          Model model) {
        model.addAttribute("taskName", taskName);
        model.addAttribute("taskTime", taskTime);
        model.addAttribute("taskDate", taskDate);
        model.addAttribute("taskDescription", taskDescription);
        return "overview";
    }
}
