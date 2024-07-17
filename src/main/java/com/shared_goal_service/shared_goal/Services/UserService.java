package com.shared_goal_service.shared_goal.Services;

import com.shared_goal_service.shared_goal.Entity.userEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    userEntity saveUserData(userEntity user);
    List<userEntity> getUserData();
    userEntity updateUserData(userEntity user);
    void deleteUserData(Long id);
    List<userEntity> getAllUserByGoalid(Long goalid);
}
