package com.shared_goal_service.shared_goal.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "goals")
@Setter
@Getter
public class GoalEntity {

    @Id
    @Column(name = "goal_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long goal_id;

    private String goalname;

    private int goalduration;

    private double goalamount;

    private double amountpaid;

    private LocalDate startdate;

    private double interestadded;

    private double interestrate;





}
