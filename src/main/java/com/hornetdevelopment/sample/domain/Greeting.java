package com.hornetdevelopment.sample.domain;

import java.util.UUID;

/**
 * Created by steve on 4/21/17.
 */
public class Greeting {

    private UUID id;
    private String name;
    private String greeting;

    public Greeting() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
