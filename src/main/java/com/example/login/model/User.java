package com.example.login.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;


@Entity
@Table(name = "users")
public class User {

    @jakarta.persistence.Id
    @Id
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String firstName;

    private String lastName;

    public User() {
    }

    public User(String username, String password, Role role, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Password
    public String getPassword() {
        return password;
    }


    // Role
    public Role getRole() {
        return role;
    }

    // First Name
    public String getFirstName() {
        return firstName;
    }


    // Last Name
    public String getLastName() {
        return lastName;
    }


    public enum Role {
        USER, MANAGER
    }
}

