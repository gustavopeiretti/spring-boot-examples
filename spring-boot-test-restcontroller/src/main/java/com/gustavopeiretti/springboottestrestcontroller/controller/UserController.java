package com.gustavopeiretti.springboottestrestcontroller.controller;


import com.gustavopeiretti.springboottestrestcontroller.model.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello User";
    }

    @GetMapping("/api/user")
    public UserDto user() {
        return new UserDto(1, "MyName", "MySurname");
    }

}
