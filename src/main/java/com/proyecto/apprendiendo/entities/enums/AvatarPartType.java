package com.proyecto.apprendiendo.entities.enums;

public enum AvatarPartType {
    BODY("BODY"),
    LEGS("GLASSES"),
    FEET("HAT");

    private final String value;

    public String getValue(){
        return value;
    }

    AvatarPartType(String value){
        this.value = value;
    }
}
