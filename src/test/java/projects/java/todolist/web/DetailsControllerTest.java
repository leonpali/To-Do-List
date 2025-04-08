package projects.java.todolist.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import projects.java.todolist.config.WebSecurityConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@Import({WebSecurityConfiguration.class, DetailsController.class})
@WebMvcTest(DetailsController.class)
public class DetailsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Details sind unter /details/{id} verfügbar")
    void test_1() throws Exception {
        mockMvc.perform(get("/details/1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("details"));
    }
}
