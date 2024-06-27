package com.freebills.boilerplatecrud2024.usecases;


import com.freebills.boilerplatecrud2024.domain.User;
import com.freebills.boilerplatecrud2024.gateways.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUser {

    private final UserGateway userGateway;

    public User update(final User user) {
        return userGateway.update(user);
    }
}
