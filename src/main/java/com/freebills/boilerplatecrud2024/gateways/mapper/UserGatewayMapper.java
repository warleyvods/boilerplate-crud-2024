package com.freebills.boilerplatecrud2024.gateways.mapper;


import com.freebills.boilerplatecrud2024.domain.User;
import com.freebills.boilerplatecrud2024.gateways.entities.UserEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface UserGatewayMapper {

    User toDomain(UserEntity userEntity);

    UserEntity toEntity(User user);

}