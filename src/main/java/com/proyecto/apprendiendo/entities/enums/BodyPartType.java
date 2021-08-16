package com.proyecto.apprendiendo.entities.enums;

public enum BodyPartType {
    HEAD("HEAD"),
    BODY("BODY"),
    LEGS("LEGS"),
    FEET("FEET");

    private final String value;

    public String getValue(){
        return value;
    }

    BodyPartType(String value){
        this.value = value;
    }
}
