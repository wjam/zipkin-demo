package com.github.wjam.recommendations.repository;

import com.github.wjam.recommendations.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationsRepository extends JpaRepository<Recommendation, Integer> {

    List<Recommendation> findByUserId(final Integer userId);

}
