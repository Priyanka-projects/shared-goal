package com.shared_goal_service.shared_goal.Services;

import com.shared_goal_service.shared_goal.Dao.GoalDao;
import com.shared_goal_service.shared_goal.Dto.GoalDto;
import com.shared_goal_service.shared_goal.Entity.goalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoalServiceImpl implements GoalService {

    @Autowired
    GoalDao goalDao;

    @Override
    public goalEntity saveGoalData(goalEntity goal) {
        return goalDao.save(goal);
    }
}
