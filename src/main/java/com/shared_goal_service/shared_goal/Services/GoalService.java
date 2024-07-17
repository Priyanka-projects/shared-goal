package com.shared_goal_service.shared_goal.Services;

import com.shared_goal_service.shared_goal.Entity.goalEntity;
import com.shared_goal_service.shared_goal.Entity.userEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface GoalService {

    goalEntity saveGoalData(goalEntity user);
}
