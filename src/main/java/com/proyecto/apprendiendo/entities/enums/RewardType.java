package com.proyecto.apprendiendo.entities.enums;

public enum RewardType {
    SOCIAL("SOCIAL"), //definido por el docente, solo se muestra
    AVATAR("AVATAR"),
    AVATAR_BODY_PART("AVATAR_BODY_PART"),
    BADGE("BADGE"),
    CHALLENGE("CHALLENGE"),
    ACHIEVEMENT("ACHIEVEMENT");

    private final String value;

    public String getValue(){
        return value;
    }

    RewardType(String value){
        this.value = value;
    }
}
