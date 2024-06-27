package com.freebills.boilerplatecrud2024.usecases;


import com.freebills.boilerplatecrud2024.domain.User;
import com.freebills.boilerplatecrud2024.gateways.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindUser {

    private final UserGateway userGateway;

    public User byId(final Long id) {
        return userGateway.findById(id);
    }

    public Boolean existsByEmail(final String email) {
        return userGateway.existsByEmail(email);
    }

    public Page<User> all(Pageable pageable) {
        return userGateway.getAll(pageable);
    }
}
