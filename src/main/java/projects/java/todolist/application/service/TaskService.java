package projects.java.todolist.application.service;

import org.springframework.stereotype.Service;
import projects.java.todolist.domain.CompletionDate;
import projects.java.todolist.domain.Task;
import projects.java.todolist.domain.TaskTime;

import java.time.LocalDate;

@Service
public class TaskService {

    public Task createTask(String name, String description, String totalTime, LocalDate completionDate) {
        return new Task(name, totalTime, description, completionDate, convertDay(completionDate));
    }

    private String convertDay(LocalDate completionDate) {
        return completionDate.getDayOfWeek().name();
    }
}
