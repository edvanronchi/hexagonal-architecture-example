package demo.domain.ports.outbound;

import demo.domain.entities.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    List<User> findAll();
}
