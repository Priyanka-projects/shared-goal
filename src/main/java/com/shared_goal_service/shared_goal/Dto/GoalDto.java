package com.shared_goal_service.shared_goal.Dto;

import com.shared_goal_service.shared_goal.Entity.goalEntity;
import com.shared_goal_service.shared_goal.Entity.userEntity;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GoalDto {
    private Long goal_id;

    private String goal_name;

    private int goal_duration;

    private double goal_amount;

    private double amount_paid;

    private LocalDate start_date;

    private double interest_added;

    private double interest_rate;

    private List<UserDto> users;

    public static GoalDto convertGoalEntityToDto(goalEntity g)
    {
        return new GoalDto(g.getGoal_id(),g.getGoal_name(),g.getGoal_duration(),g.getGoal_amount(),g.getAmount_paid(),g.getStart_date(),g.getInterest_added(),g.getInterest_rate(),g.getUsers().stream().map(UserDto::convertUserEntityToDto).collect(Collectors.toList()));
    }

    public goalEntity convertGoalDtoToEntity(GoalDto gd)
    {

        return null;
    }


}
