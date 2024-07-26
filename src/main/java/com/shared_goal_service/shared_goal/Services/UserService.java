package com.shared_goal_service.shared_goal.Services;

import com.shared_goal_service.shared_goal.Entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity saveUserData(UserEntity user);
    List<UserEntity> getUserData();
    UserEntity updateUserData(UserEntity user);
    void deleteUserData(Long id);
    List<UserEntity> getAllUserByGoalid(Long goalid);
    UserEntity getUserByUsername(String username);
}
