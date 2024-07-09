package com.shared_goal_service.shared_goal.Dto;

import com.shared_goal_service.shared_goal.Entity.userEntity;
import jakarta.persistence.Column;
import lombok.*;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GoalDto {
    private UUID goal_id;

    private String goal_name;

    private int goal_duration;

    private double goal_amount;

    private List<UserDto> users;
}
