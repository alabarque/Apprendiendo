package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class StudentReward {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long rewardId;
    private Long studentId;
    private String rewardType; //ENUM RewardType
}
