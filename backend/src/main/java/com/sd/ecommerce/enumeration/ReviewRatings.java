package com.sd.ecommerce.enumeration;

public enum ReviewRatings {
    
    ONE_STAR("ONE_STAR"),
    TWO_STAR("TWO_STAR"),
    THREE_STAR("THREE_STAR"),
    FOUR_STAR("FOUR_STAR"),
    FIVE_STAR("FIVE_STAR");

    private String rating;

    ReviewRatings(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }
}
