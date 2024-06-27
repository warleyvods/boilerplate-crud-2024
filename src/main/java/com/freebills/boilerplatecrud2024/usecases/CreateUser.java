package com.freebills.boilerplatecrud2024.usecases;

import com.freebills.boilerplatecrud2024.domain.User;
import com.freebills.boilerplatecrud2024.gateways.UserGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateUser {

    private final UserGateway userGateway;

    public User execute(final User user) {
        return userGateway.save(user);
    }
}
