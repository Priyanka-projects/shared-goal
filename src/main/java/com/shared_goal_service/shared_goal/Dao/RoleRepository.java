package com.shared_goal_service.shared_goal.Dao;

import com.shared_goal_service.shared_goal.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    public Role findByName(String name);
}
