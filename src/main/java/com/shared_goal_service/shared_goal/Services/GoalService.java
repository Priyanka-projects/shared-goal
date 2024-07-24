package com.shared_goal_service.shared_goal.Services;

import com.shared_goal_service.shared_goal.Entity.GoalEntity;

import java.util.Optional;


public interface GoalService {

    GoalEntity saveGoalData(GoalEntity user);

    Optional<GoalEntity> findById(Long Id);
}
