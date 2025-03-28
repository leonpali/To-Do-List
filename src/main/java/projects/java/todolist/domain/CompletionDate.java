package projects.java.todolist.domain;


import java.time.LocalDate;

public class CompletionDate {

    private LocalDate completionDate;
    private String completionDay;

    public CompletionDate(LocalDate completionDate, String completionDay) {
        this.completionDate = completionDate;
        this.completionDay = completionDay;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public String getCompletionDay() {
        return completionDay;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public void setCompletionDay(String completionDay) {
        this.completionDay = completionDay;
    }
}
