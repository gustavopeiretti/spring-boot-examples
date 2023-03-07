package com.gustavopeiretti.springbootautowired.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CarWithNotRequiredService {

    @Autowired(required = false)
    private EngineService engine; // This could be null !

    public void drive() {
        if (Objects.isNull(engine)) {  // prevent null pointer
            System.out.println("Engine is null!");
        }else {
            engine.start();
        }
    }

}
