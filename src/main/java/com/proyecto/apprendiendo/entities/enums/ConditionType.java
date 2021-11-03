package com.proyecto.apprendiendo.entities.enums;

public enum ConditionType {
    SOCIAL("SOCIAL"), //condicion social, simplemente se muestra a los alumnos
    TARGET_COMPLETED_X_DAYS_BEFORE_DUE_DATE("TARGET_COMPLETED_X_DAYS_BEFORE_DUE_DATE"),
    TARGET_COMPLETED_WITH_SCORE_HIGHER_THAN_X("TARGET_COMPLETED_WITH_SCORE_HIGHER_THAN_X"),
    TARGET_COMPLETED_WITH_SCORE_HIGHEST_SCORE_IN_TARGET("TARGET_COMPLETED_WITH_SCORE_HIGHEST_SCORE_IN_TARGET"),
    TARGET_COMPLETED("TARGET_COMPLETED"),
    X_PROJECTS_COMPLETED("X_PROJECTS_COMPLETED"),
    X_ACTIVITIES_COMPLETED("X_ACTIVITIES_COMPLETED"),
    X_CLASSROOMS_COMPLETED("X_CLASSROOMS_COMPLETED");


    private final String value;

    ConditionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
