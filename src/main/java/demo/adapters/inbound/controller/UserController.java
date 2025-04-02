package demo.adapters.inbound.controller;

import demo.domain.ports.inbound.CreateUserUseCase;
import demo.domain.ports.inbound.ListUsersUseCase;
import demo.domain.dto.UserRequestDTO;
import demo.domain.dto.UserResponseDTO;
import demo.utils.mappers.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final ListUsersUseCase listUsersUseCase;
    private final UserMapper userMapper;

    public UserController(CreateUserUseCase createUserUseCase, ListUsersUseCase listUsersUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.listUsersUseCase = listUsersUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO dto) {
        var user = createUserUseCase.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.entityToDtoResponse(user));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = listUsersUseCase.execute()
                .stream()
                .map(userMapper::entityToDtoResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(users);
    }
}
