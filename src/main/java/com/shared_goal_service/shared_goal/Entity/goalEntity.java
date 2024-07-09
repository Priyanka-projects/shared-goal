package com.shared_goal_service.shared_goal.Entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "goal_Entity")
public class goalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "goalID")
    private UUID goal_id;
    @Column(name = "goalName")
    private String goal_name;
    @Column(name = "goalDuration")
    private int goal_duration;
    @Column(name = "goalAmount")
    private double goal_amount;
    @ManyToMany
    @JoinTable(
            name = "userEntity",
            joinColumns = @JoinColumn(name = "goalID"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "users")
    private List<userEntity> users;
}
