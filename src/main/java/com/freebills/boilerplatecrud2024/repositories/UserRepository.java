package com.freebills.boilerplatecrud2024.repositories;



import com.freebills.boilerplatecrud2024.gateways.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Boolean existsByEmailIgnoreCase(final String email);

    Optional<UserEntity> findByEmailIgnoreCase(final String email);

}
