package com.tweteroo.tweteroo.services;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;
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

    public List<Tweets> findTweets(int page) {
        List<Tweets> tweets = repository.findAll();
        Collections.reverse(tweets);
        int diference = page*5-tweets.size();
        if (tweets.size() < page*5 && diference < 5) {
            return tweets.subList(page*5 - 5, page*5 - diference);
        }
        if (tweets.size() < page*5) {
            return new ArrayList<>();
        }
        return tweets.subList(page*5 - 5, page*5);
    }
}
