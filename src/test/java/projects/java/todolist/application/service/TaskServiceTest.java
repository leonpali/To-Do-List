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
        Task task = service.createTask("Task 1", "Test Task zum testen","2h", LocalDate.now(), "Montag");
        assertThat(task.getName()).isEqualTo("Task 1");
    }
}
