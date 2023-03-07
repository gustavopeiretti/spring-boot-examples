package com.gustavopeiretti.springbootautowired.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarWithConstructorService {

    private final EngineService engine;

    // @Autowired <- first option
    public CarWithConstructorService(@Autowired EngineService engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
    }

}
