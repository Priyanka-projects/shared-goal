package com.shared_goal_service.shared_goal.Dao;

import com.shared_goal_service.shared_goal.Entity.GoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<GoalEntity, Long>{


}
