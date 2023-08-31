package com.sd.ecommerce.enumeration;

public enum PaymentStatus {
    
    PENDING("PENDING"),
    AUTHORIZED("AUTHORIZED"),
    PAID("PAID"),
    REFUNDED("REFUNDED"),
    CANCELLED("CANCELLED");

    private String status;

    PaymentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    
}
