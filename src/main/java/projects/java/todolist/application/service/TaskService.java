package projects.java.todolist.application.service;

import org.springframework.stereotype.Service;
import projects.java.todolist.domain.CompletionDate;
import projects.java.todolist.domain.Task;
import projects.java.todolist.domain.TaskTime;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private List<Task> taskList = new ArrayList<>();

    public Task createTask(String name, String description, String totalTime, LocalDate completionDate) {
        Task task = new Task(name, totalTime, description, completionDate, convertDay(completionDate));
        taskList.add(task);
        return task;
    }

    public List<Task> getAllTasks() {
        return taskList;
    }

    private String convertDay(LocalDate completionDate) {
        return completionDate.getDayOfWeek().name();
    }
}
