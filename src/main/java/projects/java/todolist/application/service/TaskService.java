package projects.java.todolist.application.service;

import org.springframework.stereotype.Service;
import projects.java.todolist.domain.CompletionDate;
import projects.java.todolist.domain.Task;
import projects.java.todolist.domain.TaskTime;

import java.time.LocalDateTime;

@Service
public class TaskService {

    public Task createTask(String name, String description, String totalTime, LocalDateTime completionDate, String completionDay) {
        return new Task(name, totalTime, description, completionDate, completionDay);
    }
}
