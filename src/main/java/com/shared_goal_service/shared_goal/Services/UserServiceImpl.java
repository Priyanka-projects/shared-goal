package com.shared_goal_service.shared_goal.Services;

import com.shared_goal_service.shared_goal.Dao.UserRepository;
import com.shared_goal_service.shared_goal.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userDao;

    @Override
    public UserEntity saveUserData(UserEntity user) {
        return userDao.save(user);
    }

    @Override
    public List<UserEntity> getUserData() {
        return List.of();
    }

    @Override
    public UserEntity updateUserData(UserEntity user) {
        return null;
    }

    @Override
    public void deleteUserData(Long id) {

    }

    @Override
    public List<UserEntity> getAllUserByGoalid(Long goalid) {
        return userDao.getAllUsersByGoalId(goalid);
    }
}
