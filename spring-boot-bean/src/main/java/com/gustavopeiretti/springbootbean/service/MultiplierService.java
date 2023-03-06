package com.gustavopeiretti.springbootbean.service;

public class MultiplierService {

    private final int multiplier;

    public MultiplierService(int multiplier) {
        this.multiplier = multiplier;
    }

    public int multiply(int value) {
        return value * multiplier;
    }

    public void init() {
        System.out.println("Calling init method :)");
    }

    public void destroy() {
        System.out.println("Calling destroy method :(");
    }
}
