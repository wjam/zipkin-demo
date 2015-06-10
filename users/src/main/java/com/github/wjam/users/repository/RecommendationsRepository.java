package com.github.wjam.users.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Repository
public class RecommendationsRepository {

    private final RestTemplate rest;

    @Autowired
    public RecommendationsRepository(final RestTemplate rest) {
        this.rest = rest;
    }

    public List<String> getRecommendations(final Integer id) {
        final Recommendation[] recommendations = rest.getForObject("http://localhost:8082/api/recommendations/{ID}", Recommendation[].class, id);

        return Stream.of(recommendations).map(Recommendation::getRecommendation).collect(toList());
    }

}
