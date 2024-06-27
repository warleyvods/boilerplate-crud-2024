package com.freebills.boilerplatecrud2024.controllers.mappers;


import com.freebills.boilerplatecrud2024.controllers.dtos.requests.UserPostRequestDTO;
import com.freebills.boilerplatecrud2024.controllers.dtos.requests.UserPutRequestDTO;
import com.freebills.boilerplatecrud2024.controllers.dtos.responses.UserResponseDTO;
import com.freebills.boilerplatecrud2024.domain.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User toDomain(UserPostRequestDTO userPostRequestDTO);

    UserResponseDTO fromDomain(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUserFromDTO(UserPutRequestDTO userPutRequestDTO, @MappingTarget User user);

}
