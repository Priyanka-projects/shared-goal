package com.shared_goal_service.shared_goal.Entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class existingCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "custID")
    private UUID cust_id;

    private String cust_name;
    private String login_password;
    private List<String> account;
}
