package com.proyecto.apprendiendo.entities.enums;

public enum UserType {
    ADMIN("ADMIN"),
    TEACHER("TEACHER"),
    STUDENT("STUDENT");

    private final String value;

    UserType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
