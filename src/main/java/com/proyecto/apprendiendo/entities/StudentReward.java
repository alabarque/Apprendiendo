package com.proyecto.apprendiendo.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="STUDENT_REWARD")
@Table(name="STUDENT_REWARD")
public class StudentReward {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long rewardId;
    private Long studentId;
    private String rewardType; //ENUM RewardType
}
