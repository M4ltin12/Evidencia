package com.clinic;

public class Patient {
    private String id;
    private String name;
    private String condition;

    public Patient(String id, String name, String condition) {
        this.id = id;
        this.name = name;
        this.condition = condition;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCondition() {
        return condition;
    }
}