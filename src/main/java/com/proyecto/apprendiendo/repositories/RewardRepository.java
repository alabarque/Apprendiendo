package com.proyecto.apprendiendo.repositories;

import com.proyecto.apprendiendo.entities.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Long> {
    ArrayList<Reward> findByTargetIdAndRewardType(Long targetId, String rewardType);
    ArrayList<Reward> findByTargetId(Long targetId);
}
