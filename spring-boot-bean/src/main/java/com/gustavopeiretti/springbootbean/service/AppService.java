package com.gustavopeiretti.springbootbean.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    private final MultiplierService multiplierService;

    public AppService(@Autowired @Qualifier("multiplierService") MultiplierService multiplierService) {
        this.multiplierService = multiplierService;
    }

    public int calculate(int aValue) {
        return multiplierService.multiply(aValue);
    }

}
