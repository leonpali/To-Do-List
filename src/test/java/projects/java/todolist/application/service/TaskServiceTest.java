package projects.java.todolist.application.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import projects.java.todolist.domain.Task;

import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

public class TaskServiceTest {

    @Test
    @DisplayName("service.createTask() gibt Task Objekt zurück")
    void test_1() throws Exception {
        TaskService service = new TaskService();
        Task task = service.createTask("Task 1", "Test Task zum testen","2h", LocalDate.now());
        assertThat(task.getName()).isEqualTo("Task 1");
    }

    @Test
    @DisplayName("convertDay gibt richtigen String aus")
    void test_2() throws Exception {
        TaskService service = new TaskService();
        Task task = service.createTask("Task 1", "Test Task zum testen","2h", LocalDate.of(2025, 3, 28));
        assertThat(task.getCompletionDay()).isEqualToIgnoringCase("Friday");
    }

    @Test
    @DisplayName("Neu erstellte Tasks können in Liste gefunden werden")
    void test_3() throws Exception {
        TaskService service = new TaskService();
        Task task = service.createTask("Task 1", "Test Task zum testen","2h", LocalDate.now());
        assertThat(service.getAllTasks()).isNotEmpty();
    }

    @Test
    @DisplayName("Service gibt eine Map mit den Tasks nach Wochentag sortiert zurück")
    void test_4() throws Exception {
        TaskService service = new TaskService();
        Task task = service.createTask("Task 1", "Test Task zum testen","2h", LocalDate.of(2025, 3, 28));
        Task task2 = service.createTask("Task 1", "Test Task zum testen","2h", LocalDate.of(2025, 3, 28));
        assertThat(service.getTasksByDay().get("friday")).isNotEmpty();
    }

    @Test
    @DisplayName("convertDay setzt Tag auf 'week' wenn es ein Sonntag ist")
    void test_5() throws Exception {
        TaskService service = new TaskService();
        Task task = service.createTask("Task 1", "Test Task zum testen","2h", LocalDate.of(2025, 3, 30));
        assertThat(task.getCompletionDay()).isEqualToIgnoringCase("week");
    }

    @Test
    @DisplayName("getTaskById klappt")
    void test_6() throws Exception {
        TaskService service = new TaskService();
        Task t = service.createTask("Task 1", "TEST", "2h", LocalDate.now());
        t.setId(1);
        Task z = service.createTask("Task 2", "TEST", "2h", LocalDate.now());
        z.setId(2);
        assertThat(service.getTaskById(1)).isEqualTo(t);
    }

    @Test
    @DisplayName("finishTask setzt Tag auf done")
    void test_7() throws Exception {
        TaskService service = new TaskService();
        Task t = service.createTask("Task 1", "TEST", "2h", LocalDate.now());
        t.setId(1);
        service.finishTask(1);
        assertThat(service.getTaskById(1).getCompletionDay()).isEqualTo("done");
    }

    @Test
    @DisplayName("useTask ändert timeNeeded")
    void test_8() throws Exception {
        TaskService service = new TaskService();
        Task t = service.createTask("Task 1", "TEST", "2h", LocalDate.now());
        t.setId(1);
        service.useTime(1, "1h");
        assertThat(service.getTaskById(1).getNeededTime()).isEqualTo("1h");
    }

    @Test
    @DisplayName("Zeit wird richtig umgerechnet bei mehr als 60 Minuten")
    void test_9() throws Exception {
        TaskService service = new TaskService();
        Task t = service.createTask("Task 1", "TEST", "2h", LocalDate.now());
        t.setId(1);
        service.useTime(1, "80m");
        assertThat(service.getTaskById(1).getNeededTime()).isEqualTo("1h 20m");
    }
}
