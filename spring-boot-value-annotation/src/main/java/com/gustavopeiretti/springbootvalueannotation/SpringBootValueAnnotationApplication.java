package com.gustavopeiretti.springbootvalueannotation;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SpringBootValueAnnotationApplication {

    @Value("${app.example.integer-value}")
    private Integer valueInteger;

    @Value("${app.example.decimal-value}")
    private Double valueDouble;

    @Value("${app.example.boolean-value}")
    private Boolean valueBoolean;

    @Value("${app.example.nonexistent-value:'This is a default value'}")
    private String defaultValue;

    @Value("${app.example.countries}")
    private List<String> countries;

    @Value("#{${app.example.map-values}}")
    private Map<String, String> mapValues;

    @Value("${app.example.enum-value}")
    private ColorEnum color;

    @Value("${app.example.local-date}")
    private LocalDate localDate;

    @Value("${app.example.local-datetime}")
    private LocalDateTime localDateTime;

    @Autowired
    private AppComponent appComponent;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootValueAnnotationApplication.class, args);
    }

    @PostConstruct
    public void doExamples() {

        System.out.println("-- Running examples --");

        // attribute / field inject
        System.out.println("-- attribute inject --");
        System.out.println(valueInteger);
        System.out.println(valueDouble);
        System.out.println(valueBoolean);

        // constructor inject
        System.out.println("-- component inject --");
        System.out.println(appComponent.sum());

        //default value
        System.out.println("-- default value --");
        System.out.println(defaultValue);

        // arrays
        System.out.println("-- arrays --");
        countries.forEach(System.out::println);

        // map
        System.out.println("-- map --");
        mapValues.forEach((k, v) -> System.out.println((k + ":" + v)));

        // Enum
        System.out.println("-- enum --");
        System.out.println(color);

        // local dates
        System.out.println("-- local date --");
        System.out.println(localDate);

        // local date time
        System.out.println("-- local date time --");
        System.out.println(localDateTime);

    }

}
