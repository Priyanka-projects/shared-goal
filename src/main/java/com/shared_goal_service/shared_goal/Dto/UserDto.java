package com.shared_goal_service.shared_goal.Dto;

import lombok.*;

import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {

    private UUID id;
    private String user_name;
    private int user_phone;
    private String user_email;

    private boolean enabled;
    private boolean tokenExpired;



}
