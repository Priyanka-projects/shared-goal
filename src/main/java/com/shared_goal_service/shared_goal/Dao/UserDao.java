package com.shared_goal_service.shared_goal.Dao;

import com.shared_goal_service.shared_goal.Entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserDao extends JpaRepository<userEntity, UUID> {

}
