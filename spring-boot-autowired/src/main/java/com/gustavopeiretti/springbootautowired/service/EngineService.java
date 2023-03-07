package com.gustavopeiretti.springbootautowired.service;

import org.springframework.stereotype.Service;

@Service
public class EngineService {

    public void start() {
        System.out.println("Starting.. ");
    }

}
