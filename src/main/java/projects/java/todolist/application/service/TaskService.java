package projects.java.todolist.application.service;

import org.springframework.stereotype.Service;
import projects.java.todolist.domain.CompletionDate;
import projects.java.todolist.domain.Task;
import projects.java.todolist.domain.TaskTime;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, List<Task>> getTasksByDay() {
        Map<String, List<Task>> tasksByDay = new HashMap<>();
        List<Task> weekList = taskList.stream().filter(a -> a.getCompletionDay().equalsIgnoreCase("week")).toList();
        List<Task> mondayList = taskList.stream().filter(a -> a.getCompletionDay().equalsIgnoreCase("monday")).toList();
        List<Task> tuesdayList = taskList.stream().filter(a -> a.getCompletionDay().equalsIgnoreCase("tuesday")).toList();
        List<Task> wednesdayList = taskList.stream().filter(a -> a.getCompletionDay().equalsIgnoreCase("wednesday")).toList();
        List<Task> thursdayList = taskList.stream().filter(a -> a.getCompletionDay().equalsIgnoreCase("thursday")).toList();
        List<Task> fridayList = taskList.stream().filter(a -> a.getCompletionDay().equalsIgnoreCase("friday")).toList();
        List<Task> doneList = taskList.stream().filter(a -> a.getCompletionDay().equalsIgnoreCase("done")).toList();

        tasksByDay.put("week", weekList);
        tasksByDay.put("monday", mondayList);
        tasksByDay.put("tuesday", tuesdayList);
        tasksByDay.put("wednesday", wednesdayList);
        tasksByDay.put("thursday", thursdayList);
        tasksByDay.put("friday", fridayList);
        tasksByDay.put("done", doneList);
        return tasksByDay;
    }

    private String convertDay(LocalDate completionDate) {
        return completionDate.getDayOfWeek().name();
    }
}
