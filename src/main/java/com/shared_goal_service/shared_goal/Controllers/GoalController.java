package com.shared_goal_service.shared_goal.Controllers;

import com.shared_goal_service.shared_goal.Dto.GoalDto;
import com.shared_goal_service.shared_goal.Entity.GoalEntity;
import com.shared_goal_service.shared_goal.Services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoalController {

    @Autowired
    GoalService goalService;

    @PostMapping(value = "/goal/addgoal")
    public ResponseEntity<GoalDto> saveUserData(@RequestBody GoalEntity goal){
        try {
            GoalEntity ge= goalService.saveGoalData(goal);
            GoalDto gd;
            gd= GoalDto.convertGoalEntityToDto(ge);
            return ResponseEntity.status(HttpStatus.OK).body(gd);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatusCode.valueOf(500));
        }
    }

}
