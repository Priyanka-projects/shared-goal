package com.shared_goal_service.shared_goal.Services;

import com.shared_goal_service.shared_goal.Dao.UserDao;
import com.shared_goal_service.shared_goal.Entity.userEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public userEntity saveUserData(userEntity user) {
        return userDao.save(user);
    }

    @Override
    public List<userEntity> getUserData() {
        return List.of();
    }

    @Override
    public userEntity updateUserData(userEntity user) {
        return null;
    }

    @Override
    public void deleteUserData(Long id) {

    }

    @Override
    public List<userEntity> getAllUserByGoalid(Long goalid) {
        return List.of();
    }
}
