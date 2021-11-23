package com.proyecto.apprendiendo.entities.enums;

public enum TargetType {
    PROJECT("PROJECT"),
    ACTIVITY("ACTIVITY"),
    CLASSROOM("CLASSROOM"),
    STUDENT_PROJECT("STUDENT_PROJECT"),
    STUDENT_ACTIVITY("STUDENT_ACTIVITY"),
    STUDENT_CLASSROOM("STUDENT_CLASSROOM");

    private final String value;

    TargetType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
