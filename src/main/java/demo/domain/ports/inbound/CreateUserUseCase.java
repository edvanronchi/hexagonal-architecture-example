package demo.domain.ports.inbound;

import demo.domain.dto.UserRequestDTO;
import demo.domain.entities.User;

public interface CreateUserUseCase {
    User execute(UserRequestDTO dto);
}
