package com.freebills.boilerplatecrud2024.usecases;

import com.freebills.boilerplatecrud2024.gateways.UserGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteUser {

    private final UserGateway userGateway;

    public void byIds(final List<Long> ids) {
        userGateway.deleteByIds(ids);
    }

    public void byId(final Long id) {
        userGateway.deleteById(id);
        log.info("[deleteUser][userId deleted: {}]", id);
    }
}
