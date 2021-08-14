package com.proyecto.apprendiendo.entities.enums;

public enum BodypartType {
    HEAD("HEAD"),
    BODY("BODY"),
    LEGS("LEGS"),
    FEET("FEET");

    private final String value;

    public String getValue(){
        return value;
    }

    BodypartType(String value){
        this.value = value;
    }
}
