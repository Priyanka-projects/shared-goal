package com.shared_goal_service.shared_goal.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.UUID;

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

//    @ManyToMany
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = @JoinColumn(
//                    name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "role_id", referencedColumnName = "id"))
//    private Collection<Role> roles;
//
    @ManyToMany
    @JoinTable(
            name= "users_goals",
            joinColumns = @JoinColumn(
              name="user_id",referencedColumnName = "id" ),
            inverseJoinColumns =@JoinColumn(
                    name="goal_id",referencedColumnName = "goal_id"))
     private Collection<goalEntity> goals;
}
