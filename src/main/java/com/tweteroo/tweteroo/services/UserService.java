package com.tweteroo.tweteroo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.tweteroo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    

}
