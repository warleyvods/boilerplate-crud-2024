package com.freebills.boilerplatecrud2024.controllers.dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;


public record UserPostRequestDTO(
        @Schema(description = "User name application", example = "Pudge Silva")
        @NotBlank
        String name,

        @Schema(description = "Email", example = "dota@dota.com")
        @NotBlank
        String email
) {
}
