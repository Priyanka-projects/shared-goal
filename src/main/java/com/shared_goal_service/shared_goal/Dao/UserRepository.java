package com.shared_goal_service.shared_goal.Dao;

import com.shared_goal_service.shared_goal.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    @Query("SELECT u FROM UserEntity u WHERE u.username = :username")
    public UserEntity getUserByUsername(@Param("username") String username);

    @Query("SELECT u FROM UserEntity u WHERE u.goal.goal_id = :goal_id")
    public List<UserEntity> getAllUsersByGoalId(@Param("goal_id")Long goal_id);
}
