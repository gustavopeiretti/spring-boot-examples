package com.gustavopeiretti.springboottestrestcontroller.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gustavopeiretti.springboottestrestcontroller.model.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerRandomPortTest {

    @Value(value = "${local.server.port}")
    private int port;  // The port that Spring randomly assigned.

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnHello() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/hello",
                String.class)).contains("Hello User");
    }

    @Test
    public void shouldReturnUser() throws Exception {

        String expectedJson = new ObjectMapper()
                .writeValueAsString(new UserDto(1, "MyName", "MySurname"));

        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/user",
                String.class)).isEqualTo(expectedJson);
    }

}