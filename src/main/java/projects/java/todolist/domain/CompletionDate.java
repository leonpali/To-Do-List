package projects.java.todolist.domain;


import java.time.LocalDateTime;

public class CompletionDate {

    private LocalDateTime completionDate;
    private String completionDay;

    public CompletionDate(LocalDateTime completionDate, String completionDay) {
        this.completionDate = completionDate;
        this.completionDay = completionDay;
    }

    public LocalDateTime getCompletionDate() {
        return completionDate;
    }

    public String getCompletionDay() {
        return completionDay;
    }

    public void setCompletionDate(LocalDateTime completionDate) {
        this.completionDate = completionDate;
    }

    public void setCompletionDay(String completionDay) {
        this.completionDay = completionDay;
    }
}
