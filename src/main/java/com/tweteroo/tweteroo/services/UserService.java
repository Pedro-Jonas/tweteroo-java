package com.tweteroo.tweteroo.services;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.tweteroo.dto.UserDto;
import com.tweteroo.tweteroo.models.Users;
import com.tweteroo.tweteroo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;


    public void saveUser(UserDto data) {
        Stream<Users> users = repository.findAll().stream().filter(i -> i.getUsername().equals(data.username()));
        if (users.count() == 0) {
            repository.save(new Users(data));
        } else {
            System.out.println("Usuário com nome já cadastrado");
        }
    }
} 