package com.tweteroo.tweteroo.dto;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;

public record UserDto(
    @NotBlank @NonNull String username,
    @NotBlank @NonNull String avatar
    ) {  
}
