package com.tweteroo.tweteroo.models;

import com.tweteroo.tweteroo.dto.TweetsDto;

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
public class Tweets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 20, nullable = false)
    private String username;

    @Column(length = 500, nullable = false)
    private String text;

    public Tweets (TweetsDto data) {
        this.username = data.username();
        this.text = data.text();
    }
}
