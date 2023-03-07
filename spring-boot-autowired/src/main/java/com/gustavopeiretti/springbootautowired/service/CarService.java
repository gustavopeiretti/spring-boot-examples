package com.gustavopeiretti.springbootautowired.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private EngineService engine;

    public CarService(EngineService engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
    }

}
