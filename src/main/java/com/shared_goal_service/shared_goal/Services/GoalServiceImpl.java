package com.shared_goal_service.shared_goal.Services;

import com.shared_goal_service.shared_goal.Dao.GoalRepository;
import com.shared_goal_service.shared_goal.Entity.GoalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class GoalServiceImpl implements GoalService {

    @Autowired
    GoalRepository goalDao;

    @Override
    public GoalEntity saveGoalData(GoalEntity goal) {
        return goalDao.save(goal);
    }

    @Override
    public Optional<GoalEntity> findById(Long Id) {
        return goalDao.findById(Id);
    }
}
