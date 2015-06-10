package com.github.wjam.users.repository;

public class Recommendation {

    private String recommendation;

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(final String recommendation) {
        this.recommendation = recommendation;
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "recommendation='" + recommendation + '\'' +
                '}';
    }
}
