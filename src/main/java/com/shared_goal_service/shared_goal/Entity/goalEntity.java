package com.shared_goal_service.shared_goal.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Entity
@Setter
@Getter
public class goalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long goal_id;

    private String goal_name;

    private int goal_duration;

    private double goal_amount;

    private double amount_paid;

    private LocalDate start_date;

    private double interest_added;

    private double interest_rate;




    @ManyToMany(mappedBy = "goals")

    private List<userEntity> users;
}
