package com.freebills.boilerplatecrud2024.controllers.dtos.responses;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        LocalDate createdAt,
        LocalDateTime lastAccess
) {

}
