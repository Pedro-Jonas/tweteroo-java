package com.tweteroo.tweteroo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.tweteroo.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
