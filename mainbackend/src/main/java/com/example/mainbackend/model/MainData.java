package com.example.mainbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MainData")
public class MainData {
@Id
Long productId;

@Column(nullable = false,length = 150)
String productName;

@Column(nullable = false)
double price;

public MainData() {
}

public MainData(Long productId, String productName, double price) {
    this.productId = productId;
    this.productName = productName;
    this.price = price;
}

public Long getProductId() {
    return productId;
}

public void setProductId(Long productId) {
    this.productId = productId;
}

public String getProductName() {
    return productName;
}

public void setProductName(String productName) {
    this.productName = productName;
}

public double getPrice() {
    return price;
}

public void setPrice(double price) {
    this.price = price;
}


    
}
