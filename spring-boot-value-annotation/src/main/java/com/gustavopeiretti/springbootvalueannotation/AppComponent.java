package com.gustavopeiretti.springbootvalueannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppComponent {

    private final Integer valueInteger;
    private final Double valueDouble;

    public AppComponent(@Value("${app.example.integer-value}") Integer valueInteger,
                        @Value("${app.example.decimal-value}") Double valueDouble) {
        this.valueInteger = valueInteger;
        this.valueDouble = valueDouble;
    }

    public Double sum() {
        return this.valueDouble + this.valueInteger;
    }

}
