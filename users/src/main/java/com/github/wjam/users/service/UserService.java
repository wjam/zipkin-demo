package com.github.wjam.users.service;

import com.github.wjam.users.model.User;
import com.github.wjam.users.repository.RecommendationsRepository;
import com.github.wjam.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserService {

    private final UsersRepository users;
    private final RecommendationsRepository recommendations;

    @Autowired
    public UserService(final UsersRepository users, final RecommendationsRepository recommendations) {
        this.users = users;
        this.recommendations = recommendations;
    }

    @RequestMapping(value = "/api/users/{id}")
    public UserRecommendations getRecommendations(@PathVariable final Integer id) {
        final User user = users.getOne(id);
        final List<String> recommendations = this.recommendations.getRecommendations(id);

        return new UserRecommendations(user.getId(), user.getName(), recommendations);
    }

}
