package projects.java.todolist.domain;


import java.time.LocalDate;

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

    public Task(String name, String totalTime, String description, LocalDate completionDate, String completionDay) {
        this.name = name;
        this.timeValues = new TaskTime(totalTime);
        this.description = description;
        this.completionDate = new CompletionDate(completionDate, completionDay);
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

    public LocalDate getDate() {
        return completionDate.getCompletionDate();
    }

    public String getCompletionDay() {
        return completionDate.getCompletionDay();
    }

    public String getTotalTime() {
        return timeValues.getTotalTime();
    }

    public String getNeededTime() {
        return timeValues.getNeededTime();
    }

    public void setNeededTime(String time) {
        timeValues.setNeededTime(time);
    }
}
