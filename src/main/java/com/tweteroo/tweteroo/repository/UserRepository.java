package com.tweteroo.tweteroo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.tweteroo.models.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    
}
