package com.freebills.boilerplatecrud2024.gateways;

import com.freebills.boilerplatecrud2024.domain.User;
import com.freebills.boilerplatecrud2024.exceptions.UserNotFoundException;
import com.freebills.boilerplatecrud2024.gateways.mapper.UserGatewayMapper;
import com.freebills.boilerplatecrud2024.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserGateway {

    private final UserRepository userRepository;
    private final UserGatewayMapper userGatewayMapper;

    public User save(final User user) {
        return userGatewayMapper.toDomain(userRepository.save(userGatewayMapper.toEntity(user)));
    }

    public Page<User> getAll(final Pageable pageable) {
        return userRepository.findAll(pageable).map(userGatewayMapper::toDomain);
    }

    public User findById(final Long id) {
        return userGatewayMapper.toDomain(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
    }

    public User update(final User user) {
        return userGatewayMapper.toDomain(userRepository.save(userGatewayMapper.toEntity(user)));
    }

    public void deleteById(final Long id) {
        userRepository.deleteById(id);
    }

    public void deleteByIds(final List<Long> id) {
        userRepository.deleteAllById(id);
    }

    public Boolean existsByEmail(final String email) {
        return userRepository.existsByEmailIgnoreCase(email);
    }
}
