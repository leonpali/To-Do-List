package projects.java.todolist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/details")
public class DetailsController {

    @GetMapping("/{id}")
    public String details(@PathVariable String id) {
        return "details";
    }

    @PostMapping("/{id}/done")
    public String done(@PathVariable String id) {
        return "redirect:/overview";
    }
}
