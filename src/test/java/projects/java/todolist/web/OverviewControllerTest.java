package projects.java.todolist.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import projects.java.todolist.application.service.TaskService;
import projects.java.todolist.config.WebSecurityConfiguration;

import java.time.LocalDate;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Import({OverviewController.class, WebSecurityConfiguration.class, TaskService.class})
@WebMvcTest(OverviewController.class)
public class OverviewControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    TaskService service;

    @Test
    @DisplayName("Wenn man /overvíew aufruft gelangt man auf die Overview Seite")
    void test_1() throws Exception {
        mockMvc.perform(get("/overview"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("overview"))
                .andExpect(model().attribute("tasksByDay", service.getTasksByDay()));
    }

    @Test
    @DisplayName("POST /overview funktioniert")
    void test_2() throws Exception {
        mockMvc.perform(post("/overview")
                        .param("taskName", "Code pushen")
                        .param("taskTime", "1h 30m")
                        .param("taskDate", String.valueOf(LocalDate.now()))
                        .param("taskDescription", "Code auf Github pushen"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("overview"))
                .andExpect(model().attribute("tasksByDay", service.getTasksByDay()));
    }

    @Test
    @DisplayName("Wenn Name leer ist wird InvalidTaskException geworfen")
    void test_3() throws Exception {
        mockMvc.perform(post("/overview")
                        .param("taskName", "")
                        .param("taskTime", "1h 30m")
                        .param("taskDate", String.valueOf(LocalDate.now()))
                        .param("taskDescription", "Code auf Github pushen"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Name darf nicht leer sein"));
    }

    @Test
    @DisplayName("Wenn Zeit im falschen Format ist wird InvalidTaskException geworfen")
    void test_4() throws Exception {
        mockMvc.perform(post("/overview")
                        .param("taskName", "Task 1")
                        .param("taskTime", "AAA")
                        .param("taskDate", String.valueOf(LocalDate.now()))
                        .param("taskDescription", "Code auf Github pushen"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Zeit muss im Format 'hh:mm' angegeben werden"));
    }

    @Test
    @DisplayName("Wenn Datum leer ist wird InvalidTaskException geworfen")
    void test_5() throws Exception {
        mockMvc.perform(post("/overview")
                        .param("taskName", "Task 1")
                        .param("taskTime", "1h 30m")
                        .param("taskDate", "")
                        .param("taskDescription", "Code auf Github pushen"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Datum darf nicht leer sein"));
    }
}
