package com.nextax.nextax.model;

import jakarta.persistence.*;

@Entity
@Table(name = "userdata_")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double total;
    private Double taxAmount;
    private String userName;
    private String userEmail;

    // Constructors, getters, and setters
    public UserData() {}

    public UserData(Long id, User user, Double total, Double taxAmount, String userName, String userEmail) {
        this.id = id;
        this.user = user;
        this.total = total;
        this.taxAmount = taxAmount;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    // Remove tax getter and setter
    // public Tax getTax() { return tax; }
    // public void setTax(Tax tax) { this.tax = tax; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
    public Double getTaxAmount() { return taxAmount; }
    public void setTaxAmount(Double taxAmount) { this.taxAmount = taxAmount; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
}