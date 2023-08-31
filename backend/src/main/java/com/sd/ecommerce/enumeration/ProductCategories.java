package com.sd.ecommerce.enumeration;

public enum ProductCategories {
    
    ELECTRONICS("ELECTRONICS"),
    FASHION("FASHION"),
    HOME("HOME"),
    BOOKS("BOOKS"),
    SPORTS("SPORTS"),
    TOYS("TOYS"),
    KITCHEN("KITCHEN"),
    BEAUTY("BEAUTY"),
    HEALTH("HEALTH"),
    BABY("BABY"),
    GROCERY("GROCERY"),
    STATIONARY("STATIONARY");

    private String category;

    ProductCategories(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

}
