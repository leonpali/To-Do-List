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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public TaskTime getTimeValues() {
        return timeValues;
    }

    public CompletionDate getCompletionDate() {
        return completionDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTimeValues(TaskTime timeValues) {
        this.timeValues = timeValues;
    }

    public void setCompletionDate(CompletionDate completionDate) {
        this.completionDate = completionDate;
    }
}
