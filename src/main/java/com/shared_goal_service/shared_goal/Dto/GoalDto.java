package com.shared_goal_service.shared_goal.Dto;

import com.shared_goal_service.shared_goal.Entity.GoalEntity;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GoalDto {
    private Long goal_id;

    private String goalname;

    private int goalduration;

    private double goalamount;

    private double amountpaid;

    private LocalDate startdate;

    private double interestadded;

    private double interestrate;



    public static GoalDto convertGoalEntityToDto(GoalEntity g)
    {
        return new GoalDto(g.getGoal_id(),g.getGoalname(),g.getGoalduration(),g.getGoalamount(),g.getAmountpaid(),g.getStartdate(),g.getInterestadded(),g.getInterestrate());
    }

    public GoalEntity convertGoalDtoToEntity(GoalDto gd)
    {

        return null;
    }


}
