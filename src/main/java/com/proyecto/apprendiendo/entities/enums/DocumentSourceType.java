package com.proyecto.apprendiendo.entities.enums;

public enum DocumentSourceType {
    STUDENT("STUDENT"),
    TEACHER("TEACHER"),
    PROJECT("PROJECT"),
    CLASSROOM("CLASSROOM"),
    ACTIVITY("ACTIVITY");

    private final String value;

    public String getValue(){
        return value;
    }

    DocumentSourceType(String value){
        this.value = value;
    }
}