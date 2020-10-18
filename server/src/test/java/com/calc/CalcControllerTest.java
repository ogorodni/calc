package com.calc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CalcController.class)
class CalcControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void stringParameterInPathVariable() throws Exception {
        mockMvc.perform(get("/calc" + '?' + "expr=1 + 2"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("3")));
    }

    @Test
    void jsonParameterInRequestBody() throws Exception {
        mockMvc.perform(post("/calc")
                .contentType("application/json")
                .content("1 + 1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("2")));

    }
}