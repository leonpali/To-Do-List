package projects.java.todolist.domain;

public class TaskTime {

    private String totalTime;
    private String neededTime;

    public TaskTime(String totalTime, String neededTime) {
        this.totalTime = totalTime;
        this.neededTime = neededTime;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public String getNeededTime() {
        return neededTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public void setNeededTime(String neededTime) {
        this.neededTime = neededTime;
    }
}
