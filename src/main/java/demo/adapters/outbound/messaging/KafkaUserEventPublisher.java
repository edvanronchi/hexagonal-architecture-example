package demo.adapters.outbound.messaging;

import demo.domain.dto.UserMessageDTO;
import demo.domain.entities.User;
import demo.domain.ports.outbound.UserEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaUserEventPublisher implements UserEventPublisher {

    private final KafkaTemplate<String, UserMessageDTO> kafkaTemplate;

    public KafkaUserEventPublisher(KafkaTemplate<String, UserMessageDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(UserMessageDTO message) {
        kafkaTemplate.send("user-events", message);
    }
}
