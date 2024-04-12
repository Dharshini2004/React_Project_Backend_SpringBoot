package com.example.mydreamgardenbackend.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="UserLogin")
public class Login {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Column(nullable = false,length = 50,unique = true)
    String username;

    @Column(nullable = false,length=20)
    String password;

    //one to many with Order
    @OneToMany(mappedBy = "login", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Order> orders = new ArrayList<>();
    

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Login() {
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    // public int getId() {
    //     return Id;
    // }

    // public void setId(int id) {
    //     Id = id;
    // }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
