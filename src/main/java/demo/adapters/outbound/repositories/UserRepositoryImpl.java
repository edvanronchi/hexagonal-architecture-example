package demo.adapters.outbound.repositories;

import demo.adapters.outbound.entities.JpaUserEntity;
import demo.domain.entities.User;
import demo.domain.ports.outbound.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository repository;

    public UserRepositoryImpl(JpaUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        JpaUserEntity entity = new JpaUserEntity(user);
        return repository.save(entity).toDomain();
    }

    @Override
    public List<User> findAll() {
        return repository.findAll().stream()
                .map(JpaUserEntity::toDomain)
                .collect(Collectors.toList());
    }
}
