package com.github.wjam.recommendations.service;

import com.github.wjam.recommendations.model.Recommendation;
import com.github.wjam.recommendations.repository.RecommendationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecommendationsService {

    private final RecommendationsRepository repository;

    @Autowired
    public RecommendationsService(final RecommendationsRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/api/recommendations/{user}")
    public List<Recommendation> getRecommendations(@PathVariable final Integer user) {
        return repository.findByUserId(user);
    }

}
