package com.nextax.nextax.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "users_")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        @JsonProperty("user_name")

    private String name;
    private String email;
    private String password;
    private String roles;

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserData> userData;

    // Constructors, getters, and setters
    public User() {}

    public User(Long id, String name, String email, String password,String roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles=roles;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public List<UserData> getUserData() { return userData; }
    public void setUserData(List<UserData> userData) { this.userData = userData; }

}