package projects.java.todolist.domain;

public class TaskTime {

    private String totalTime;
    private String neededTime;
    private int hours;
    private int minutes;

    public TaskTime(String totalTime, String neededTime, int hours, int minutes) {
        this.totalTime = totalTime;
        this.neededTime = neededTime;
        this.hours = hours;
        this.minutes = minutes;
    }

    public TaskTime(String totalTime) {
        this.totalTime = totalTime;
        this.neededTime = "0m";
        this.hours = 0;
        this.minutes = 0;
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

    public void addNeededTime(String neededTime) {
        if(neededTime.endsWith("h")) {
            this.hours += Integer.parseInt(neededTime.split("h")[0]);
        } else if (neededTime.contains("h")){
            this.hours += Integer.parseInt(neededTime.split("h")[0]);
            this.minutes += Integer.parseInt(neededTime.split("h")[1].split("m")[0]);
        } else {
            this.minutes += Integer.parseInt(neededTime.split("m")[0]);
        }

        if (this.minutes == 0) {
            this.neededTime = this.hours + "h";
        } else {
            this.neededTime = this.hours + "h " + this.minutes + "m";
        }
    }
}
