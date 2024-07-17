package com.shared_goal_service.shared_goal.Dto;

import com.shared_goal_service.shared_goal.Entity.goalEntity;
import com.shared_goal_service.shared_goal.Entity.userEntity;
import lombok.*;

import java.util.Collection;
import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {

    private UUID id;
    private String user_name;
    private String user_phone;
    private String user_email;
    private String password;
    private boolean enabled;
    private boolean tokenExpired;

    private Collection<goalEntity> goals;

    public static UserDto convertUserEntityToDto(userEntity u)
    {
        UserDto userdto = new UserDto(u.getId(),u.getUser_name(),u.getUser_phone(),u.getUser_email(),u.getPassword(),u.isEnabled(),u.isTokenExpired(),u.getGoals());
        return userdto;
    }

    public userEntity convertUserDtoToEntity(UserDto ud)
    {
        userEntity userentity = new userEntity();
        userentity.setId(ud.getId());
        userentity.setUser_name(ud.getUser_name());
        userentity.setUser_email(ud.getUser_email());
        userentity.setUser_phone(ud.getUser_phone());
        userentity.setUser_name(ud.getPassword());
        userentity.setEnabled(ud.isEnabled());
        userentity.setTokenExpired(ud.isTokenExpired());
        userentity.setGoals(ud.getGoals());

        return userentity;
    }





}
