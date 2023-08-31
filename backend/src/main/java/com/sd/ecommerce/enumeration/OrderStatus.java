package com.sd.ecommerce.enumeration;

public enum OrderStatus {
    
    PENDING("PENDING"),
    PROCESSING("PROCESSING"),
    SHIPPED("SHIPPED"),
    DELIVERED("DELIVERED"),
    CANCELLED("CANCELLED"),
    REFUNDED("REFUNDED");

    private String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
