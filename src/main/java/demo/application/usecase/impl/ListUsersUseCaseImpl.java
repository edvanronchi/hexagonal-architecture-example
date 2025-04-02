package demo.application.usecase.impl;

import demo.domain.ports.inbound.ListUsersUseCase;
import demo.domain.entities.User;
import demo.domain.ports.outbound.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListUsersUseCaseImpl implements ListUsersUseCase {

    private final UserRepository userRepository;

    public ListUsersUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> execute() {
        return this.userRepository.findAll();
    }
}
