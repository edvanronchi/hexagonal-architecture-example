package demo.domain.ports.outbound;

import demo.domain.dto.UserMessageDTO;
import demo.domain.entities.User;

public interface UserEventPublisher {
    void publish(UserMessageDTO message);
}
