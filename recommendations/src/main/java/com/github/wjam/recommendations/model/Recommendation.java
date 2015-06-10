package com.github.wjam.recommendations.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Recommendation {

    @Id
    private Integer id;
    private Integer userId;
    private String recommendation;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(final String recommendation) {
        this.recommendation = recommendation;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "id=" + id +
                ", userId=" + userId +
                ", recommendation='" + recommendation + '\'' +
                '}';
    }
}
