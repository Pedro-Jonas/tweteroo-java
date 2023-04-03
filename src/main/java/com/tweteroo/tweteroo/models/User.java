package com.tweteroo.tweteroo.models;

import com.tweteroo.tweteroo.dto.UserDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 5, nullable = false)
    private String username;

    @Column(length = 10, nullable = false)
    private String avatar;
 
    public User (UserDto data) {
        this.username = data.username();
        this.avatar = data.avatar();
    }
}
