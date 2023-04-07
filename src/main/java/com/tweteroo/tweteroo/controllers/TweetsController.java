package com.tweteroo.tweteroo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweteroo.dto.TweetsDto;
import com.tweteroo.tweteroo.models.Tweets;
import com.tweteroo.tweteroo.services.TweetsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetsController {
    @Autowired
    private TweetsService service;

    @PostMapping
    public String postTweets(@RequestBody @Valid TweetsDto req) {
        service.saveTweet(req);
        return "OK"; 
    }

    @GetMapping
    public List<Tweets>getTweets(@RequestParam("page") int page)  {
        return service.findTweets(page);
    }

    @GetMapping("/{USERNAME}")
    public List<Tweets>getTweetsByUsername(@PathVariable("USERNAME") String username)  {
        return service.findTweetsByUsername(username);
    }

}
