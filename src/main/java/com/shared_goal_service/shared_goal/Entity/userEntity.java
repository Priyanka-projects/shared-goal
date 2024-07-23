package com.shared_goal_service.shared_goal.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Setter
@Getter
public class userEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;
    private String user_name;
    private String user_phone;
    private String user_email;
    @Column(name = "password")
    private String password;
    private boolean enabled;
    private boolean tokenExpired;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Role> roles =new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name= "users_goals",
            joinColumns = @JoinColumn(
              name="user_id",referencedColumnName = "id" ),
            inverseJoinColumns =@JoinColumn(
                    name="goal_id",referencedColumnName = "goal_id"))
     private Collection<goalEntity> goals;
}
