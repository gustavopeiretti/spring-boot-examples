package com.gustavopeiretti.springboottestrestcontroller.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gustavopeiretti.springboottestrestcontroller.model.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerWebMvcTestTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnHelloWorld() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello User")));
    }

    @Test
    void shouldReturnUser() throws Exception {
        String expectedJson = new ObjectMapper()
                .writeValueAsString(new UserDto(1, "MyName", "MySurname"));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/user"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));
    }

}