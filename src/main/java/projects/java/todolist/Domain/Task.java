package projects.java.todolist.Domain;

import java.time.LocalDateTime;

public class Task {

    private int id;
    private String name;
    private String description;
    private TaskTime timeValues;
    private CompletionDate completionDate;

    public Task(String name, TaskTime timeValues, String description, CompletionDate completionDate) {
        this.name = name;
        this.timeValues = timeValues;
        this.description = description;
        this.completionDate = completionDate;
    }

    public Task(int id, String name, TaskTime timeValues, String description, CompletionDate completionDate) {
        this.id = id;
        this.name = name;
        this.timeValues = timeValues;
        this.description = description;
        this.completionDate = completionDate;
    }
}
