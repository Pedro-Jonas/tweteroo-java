package com.tweteroo.tweteroo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.tweteroo.dto.TweetsDto;
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
}
