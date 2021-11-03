package com.proyecto.apprendiendo.entities.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StatisticDTO {
    private Object item;
    private Double averageCompletion;
    private Double percentageCompleted;
    private Double averageGrade;
    private Double averageDaysToComplete;
    private Double averageDaysToDueDate;
}
