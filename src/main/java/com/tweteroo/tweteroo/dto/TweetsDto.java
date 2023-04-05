package com.tweteroo.tweteroo.dto;

import jakarta.validation.constraints.NotBlank;

public record TweetsDto(
    @NotBlank String username,
    @NotBlank String text
    ) {   
}
