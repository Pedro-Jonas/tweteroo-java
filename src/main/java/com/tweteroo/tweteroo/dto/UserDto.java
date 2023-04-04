package com.tweteroo.tweteroo.dto;

import jakarta.validation.constraints.NotBlank;

public record UserDto(
    @NotBlank String username,
    @NotBlank String avatar
    ) {  
}