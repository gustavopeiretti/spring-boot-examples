package com.gustavopeiretti.springbootadvice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DemoControllerTest {

    private final MockMvc mockMvc;

    DemoControllerTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void demo() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/demo-error"))
                .andDo(print())
                .andExpect(status().is5xxServerError())
                .andExpect(content().string(containsString("An error occurred - Generic Runtime error")));
    }

    @Test
    void demoCustomError() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/demo-custom-error"))
                .andDo(print())
                .andExpect(status().is5xxServerError())
                .andExpect(content().string(containsString("A custom error occurred - Custom exception error")));
    }

    @Test
    void demoCustomErrorStatus() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/demo-custom-error-status"))
                .andDo(print())
                .andExpect(status().isConflict()) // status 409
                .andExpect(content().string(containsString("A error with ResponseStatus annotation")));
    }
}