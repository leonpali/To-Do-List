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
}
