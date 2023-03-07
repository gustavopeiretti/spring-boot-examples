package com.gustavopeiretti.springbootautowired.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarWithSetService {

    private EngineService engine;

    @Autowired
    public void setEngine(EngineService engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
    }


}
