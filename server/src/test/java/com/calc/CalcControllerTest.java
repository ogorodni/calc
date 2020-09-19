package com.calc;

import com.calc.domain.Exercise;
import com.calc.domain.Operation;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(controllers = CalcController.class)
class CalcControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenValidInput_thenReturnsCorrectResult() throws Exception {
        Exercise ex = new Exercise(Operation.SUM, BigDecimal.valueOf(6), BigDecimal.valueOf(5));
        mockMvc.perform(post("/calc")
        .contentType("application/json")
        .content(new Gson().toJson(ex)))
                .andExpect(content().string(containsString("Result = 11")));
    }
}