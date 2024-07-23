package com.shared_goal_service.shared_goal.Controllers;

import com.shared_goal_service.shared_goal.Dto.UserDto;
import com.shared_goal_service.shared_goal.Entity.userEntity;
import com.shared_goal_service.shared_goal.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.shared_goal_service.shared_goal.Dto.UserDto.convertUserEntityToDto;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/user/addUser")
    public ResponseEntity saveUserData(@RequestBody userEntity user){
        try {
          userEntity ue= userService.saveUserData(user);
            UserDto ud;
            ud=UserDto.convertUserEntityToDto(ue);
           return ResponseEntity.status(HttpStatus.OK).body(ud);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.MULTI_STATUS).body(e.fillInStackTrace());
        }
    }


    @GetMapping(value = "/user/getAllUserByGoalid")
    public ResponseEntity getAllUserByGoalid(@RequestParam Long goalid)
    {
        try{
            List<UserDto> userDtoList =new ArrayList<>();

            return ResponseEntity.status((HttpStatus.OK)).body(userDtoList);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatusCode.valueOf(500));
        }
    }



}
