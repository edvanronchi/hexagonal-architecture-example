package demo.application.usecase.impl;

import demo.domain.ports.inbound.CreateUserUseCase;
import demo.domain.dto.UserMessageDTO;
import demo.domain.dto.UserRequestDTO;
import demo.domain.entities.User;
import demo.domain.ports.outbound.UserEventPublisher;
import demo.domain.ports.outbound.UserRepository;
import demo.utils.mappers.UserMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserEventPublisher userEventPublisher;

    public CreateUserUseCaseImpl(UserRepository userRepository, UserMapper userMapper, UserEventPublisher userEventPublisher) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userEventPublisher = userEventPublisher;
    }

    @Override
    public User execute(UserRequestDTO dto) {
        User user = userRepository.save(userMapper.dtoToEntity(dto));

        UserMessageDTO message = new UserMessageDTO(user.getId(), LocalDateTime.now());
        userEventPublisher.publish(message);

        return user;
    }
}
