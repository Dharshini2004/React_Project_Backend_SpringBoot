package com.example.mydreamgardenbackend.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    
    @Column(nullable = false,unique = true)
    int orderId;

    @Column(nullable = false)
    int storeId;
    
    @Column(nullable = false,length = 100)
    String storeName;

    @Column(nullable = false)
    private double price;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @Column(name = "deliver_date")
    private Date deliverDate;


    @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "login_id")
    @JsonBackReference
    private Login login;

    
    public Order() {
    }

    public Order(int id, int orderId, int storeId, String storeName, double price, Date orderDate, Date deliverDate) {
        Id = id;
        this.orderId = orderId;
        this.storeId = storeId;
        this.storeName = storeName;
        this.price = price;
        this.orderDate = orderDate;
        this.deliverDate = deliverDate;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
                
    
    
}
