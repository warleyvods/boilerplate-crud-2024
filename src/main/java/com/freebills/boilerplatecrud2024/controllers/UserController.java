package com.freebills.boilerplatecrud2024.controllers;


import com.freebills.boilerplatecrud2024.controllers.dtos.requests.UserPostRequestDTO;
import com.freebills.boilerplatecrud2024.controllers.dtos.requests.UserPutRequestDTO;
import com.freebills.boilerplatecrud2024.controllers.dtos.responses.UserResponseDTO;
import com.freebills.boilerplatecrud2024.controllers.mappers.UserMapper;
import com.freebills.boilerplatecrud2024.usecases.CreateUser;
import com.freebills.boilerplatecrud2024.usecases.DeleteUser;
import com.freebills.boilerplatecrud2024.usecases.FindUser;
import com.freebills.boilerplatecrud2024.usecases.UpdateUser;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@Tag(name = "User Controller")
@RequiredArgsConstructor
@RequestMapping("v1/user")
@RestController
public class UserController {

    private final CreateUser createUser;
    private final FindUser findUser;
    private final DeleteUser deleteUser;
    private final UserMapper userMapper;
    private final UpdateUser updateUser;

    @ResponseStatus(CREATED)
    @PostMapping
    public UserResponseDTO save(@RequestBody @Valid final UserPostRequestDTO userPostRequestDTO) {
        final var user = createUser.execute(userMapper.toDomain(userPostRequestDTO));
        return userMapper.fromDomain(user);
    }

    @ResponseStatus(OK)
    @PutMapping
    public UserResponseDTO update(@RequestBody @Valid final UserPutRequestDTO userPutRequestDTO) {
        final var userFinded = findUser.byId(userPutRequestDTO.id());
        final var toJson = updateUser.update(userMapper.updateUserFromDTO(userPutRequestDTO, userFinded));
        return userMapper.fromDomain(toJson);
    }


    @ResponseStatus(OK)
    @GetMapping("{id}")
    public UserResponseDTO findById(@PathVariable final Long id) {
        final var user = findUser.byId(id);
        return userMapper.fromDomain(user);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable final Long id) {
        deleteUser.byId(id);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping
    public void deleteByIds(@RequestParam final List<Long> ids) {
        deleteUser.byIds(ids);
    }

    @ResponseStatus(OK)
    @GetMapping
    public Page<UserResponseDTO> findAll(Pageable pageable) {
        return findUser.all(pageable).map(userMapper::fromDomain);
    }
}
