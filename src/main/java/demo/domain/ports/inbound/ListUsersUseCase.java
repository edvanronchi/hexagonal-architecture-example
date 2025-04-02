package demo.domain.ports.inbound;

import demo.domain.entities.User;

import java.util.List;

public interface ListUsersUseCase {
    List<User> execute();
}
