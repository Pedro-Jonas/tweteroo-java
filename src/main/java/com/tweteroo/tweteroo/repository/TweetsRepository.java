package com.tweteroo.tweteroo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.tweteroo.models.Tweets;

public interface TweetsRepository extends JpaRepository<Tweets, Long> {
    
}
