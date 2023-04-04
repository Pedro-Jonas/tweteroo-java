package com.tweteroo.tweteroo.services;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Users> users = repository.findAll().stream().filter(i -> i.getUsername().equals(data.username())).collect(Collectors.toList());
        if (users.isEmpty()) {
            repository.save(new Users(data));
        } else {
            System.out.println("Usuário com nome já cadastrado");
        } 
    }
} 