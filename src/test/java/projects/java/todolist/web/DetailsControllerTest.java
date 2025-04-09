package projects.java.todolist.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import projects.java.todolist.application.service.TaskService;
import projects.java.todolist.config.WebSecurityConfiguration;
import projects.java.todolist.domain.Task;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Import({WebSecurityConfiguration.class, DetailsController.class, TaskService.class})
@WebMvcTest(DetailsController.class)
public class DetailsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    private TaskService s;

    @Test
    @DisplayName("Details sind unter /details/{id} verfügbar")
    void test_1() throws Exception {
        Task t = new Task( "1", "2h", "test", LocalDate.now(), "monday");
        t.setId(1);

        when(s.getTaskById(1)).thenReturn(t);
        
        mockMvc.perform(get("/details/1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("details"))
                .andExpect(model().attribute("taskName", "1"));
    }

    @Test
    @DisplayName("POST Mapping für Abschließen Button klappt")
    void test_2() throws Exception {
        mockMvc.perform(post("/details/1/done"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/overview"));
    }

    @Test
    @DisplayName("Task kann mit Abschließen Button auf done gesetzt werden")
    void test_3() throws Exception {
        Task t = new Task( "1", "2h", "test", LocalDate.now(), "monday");
        t.setId(1);

        when(s.getTaskById(1)).thenReturn(t);

        mockMvc.perform(post("/details/1/done"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/overview"));

        verify(s).finishTask(1);
    }

    @Test
    @DisplayName("POST Mapping für Zeit protokollieren klappt")
    void test_4() throws Exception {
        mockMvc.perform(post("/details/1/useTime"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("details"));
    }
}
