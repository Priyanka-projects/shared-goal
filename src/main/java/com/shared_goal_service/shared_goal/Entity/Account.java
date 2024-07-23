package com.shared_goal_service.shared_goal.Entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String account_no;
    private String type;
    private double balance;

    @OneToOne(mappedBy = "account")
    private existingCustomer customer;
}
