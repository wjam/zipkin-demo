package com.github.wjam.users.service;

import java.util.List;

public class UserRecommendations {

    private final Integer id;
    private final String name;
    private final List<String> recommendations;

    public UserRecommendations(final Integer id, final String name, final List<String> recommendations) {
        this.id = id;
        this.name = name;
        this.recommendations = recommendations;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendations() {
        return recommendations;
    }

    @Override
    public String toString() {
        return "UserRecommendations{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", recommendations=" + recommendations +
                '}';
    }
}
