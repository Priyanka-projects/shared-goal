package com.shared_goal_service.shared_goal.Dto;

import com.shared_goal_service.shared_goal.Entity.Role;
import com.shared_goal_service.shared_goal.Entity.GoalEntity;
import com.shared_goal_service.shared_goal.Entity.UserEntity;
import lombok.*;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {

    private Long id;
    private String username;
    private String userphone;
    private String useremail;
    private String password;
    private boolean enabled;

    private Set<Role> roles ;
    private GoalEntity goal;

    public static UserDto convertUserEntityToDto(UserEntity u)
    {
        UserDto userdto = new UserDto(u.getId(),u.getUsername(),u.getUserphone(),u.getUseremail(),u.getPassword(),u.isEnabled(),u.getRoles(),u.getGoal());
        return userdto;
    }

    public UserEntity convertUserDtoToEntity(UserDto ud)
    {
        UserEntity userentity = new UserEntity();
        userentity.setId(ud.getId());
        userentity.setUsername(ud.getUsername());
        userentity.setUseremail(ud.getUseremail());
        userentity.setUserphone(ud.getUserphone());
        userentity.setPassword(ud.getPassword());
        userentity.setEnabled(ud.isEnabled());
        userentity.setRoles(ud.getRoles());
        userentity.setGoal(ud.getGoal());

        return userentity;
    }





}
