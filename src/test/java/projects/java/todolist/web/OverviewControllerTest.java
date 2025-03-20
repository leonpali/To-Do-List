package projects.java.todolist.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@Import(OverviewController.class)
@WebMvcTest(OverviewController.class)
public class OverviewControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Wenn man /overvíew aufruft gelangt man auf die Overview Seite")
    void test_1() throws Exception {
        mockMvc.perform(get("/overview"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("overview"));
    }
}
