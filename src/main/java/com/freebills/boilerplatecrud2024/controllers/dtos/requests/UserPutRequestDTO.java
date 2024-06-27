package com.freebills.boilerplatecrud2024.controllers.dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record UserPutRequestDTO(
        @Schema(description = "User id", example = "1")
        Long id,

        @Schema(description = "User name application", example = "Pudge Silva")
        @NotBlank
        String name,

        @Schema(description = "Email", example = "dota@dota.com")
        @NotBlank
        String email
) {
}
