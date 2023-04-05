package com.tweteroo.tweteroo.services;

import java.util.stream.Collectors;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.tweteroo.dto.TweetsDto;
import com.tweteroo.tweteroo.models.Tweets;
import com.tweteroo.tweteroo.models.Users;
import com.tweteroo.tweteroo.repository.TweetsRepository;
import com.tweteroo.tweteroo.repository.UserRepository;

@Service
public class TweetsService {
    @Autowired
    private TweetsRepository repository;

    @Autowired 
    private UserRepository userRepository;

    public void saveTweet(TweetsDto data) {
        List<Users> user = userRepository.findAll().stream().filter(i -> i.getUsername().equals(data.username())).collect(Collectors.toList());
        if (!user.isEmpty()) {
            repository.save(new Tweets(data));
        } else {
            System.out.println("Usuário não cadastrado");
        }
    }
}
