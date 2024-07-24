package com.shared_goal_service.shared_goal.Controllers;

import com.shared_goal_service.shared_goal.Dao.RoleRepository;
import com.shared_goal_service.shared_goal.Dto.UserDto;
import com.shared_goal_service.shared_goal.Entity.GoalEntity;
import com.shared_goal_service.shared_goal.Entity.Role;
import com.shared_goal_service.shared_goal.Entity.UserEntity;
import com.shared_goal_service.shared_goal.Services.GoalService;
import com.shared_goal_service.shared_goal.Services.GoalServiceImpl;
import com.shared_goal_service.shared_goal.Services.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    GoalService goalService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //new goal to be added with admin basically who creates goal
    @PostMapping(value = "/user/addUser")
    public ResponseEntity saveUserData(@RequestBody UserEntity user){
        try {
            String password = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(password);
            Role admin = roleRepository.findByName("ADMIN");
            user.getRoles().add(admin);
            GoalEntity goalToBeAdded=goalService.saveGoalData(user.getGoal());
            user.setGoal(goalToBeAdded);
            UserEntity ue= userService.saveUserData(user);
            UserDto ud;
            ud= UserDto.convertUserEntityToDto(ue);
           return ResponseEntity.status(HttpStatus.OK).body(ud);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.fillInStackTrace());
        }
    }

 @PostMapping(value = "/new/member/add")
 public ResponseEntity addMemberExistingGoal(@RequestBody UserEntity user)
 {
     try {

         String password = bCryptPasswordEncoder.encode(user.getPassword());
         user.setPassword(password);
         Role role = roleRepository.findByName("USER");
         user.getRoles().add(role);

         Optional<GoalEntity> goal=goalService.findById(user.getGoal().getGoal_id());
         user.setGoal(goal.get());

         UserEntity ue= userService.saveUserData(user);
         UserDto ud;
         ud= UserDto.convertUserEntityToDto(ue);
         return ResponseEntity.status(HttpStatus.OK).body(ud);
     }
     catch (Exception e)
     {
         return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(e.fillInStackTrace());
     }
 }






    @GetMapping(value = "viewall/AllUserByGoalid")
    public ResponseEntity getAllUserByGoalid(@RequestParam Long goalid)
    {
        try{
            List<UserEntity> usersWithSameGoal = userService.getAllUserByGoalid(goalid);
            ModelMapper mapper = new ModelMapper();

            List<UserDto> userDtoList= Arrays.asList(mapper.map(usersWithSameGoal, UserDto[].class));

            return ResponseEntity.status((HttpStatus.OK)).body(userDtoList);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatusCode.valueOf(500));
        }
    }


   //this is to test the auth no logic here
    @GetMapping("/view/goal")
    public String getOne(){
        return "view goal ";
    }



}
