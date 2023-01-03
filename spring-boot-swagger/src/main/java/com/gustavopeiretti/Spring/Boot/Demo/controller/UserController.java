package com.gustavopeiretti.Spring.Boot.Demo.controller;


import com.gustavopeiretti.Spring.Boot.Demo.model.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/api/user/{id}")
    public UserDto byId(@PathVariable("id") int id) {
        return new UserDto(id, "Name " + id, "Surname " + id);
    }

    @PostMapping("/api/user/")
    public UserDto create(@RequestBody UserDto user) {
        return new UserDto();
    }

    @PutMapping("/api/user/")
    public UserDto update(@RequestBody UserDto user) {
        return new UserDto();
    }

    @PatchMapping("/api/user/")
    public UserDto change(@RequestBody UserDto user) {
        return new UserDto();
    }

    @DeleteMapping("/api/user/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return true;
    }

}
