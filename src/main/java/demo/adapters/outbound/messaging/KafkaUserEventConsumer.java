package demo.adapters.outbound.messaging;

import demo.domain.dto.UserMessageDTO;
import demo.domain.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaUserEventConsumer {
    private static final Logger log = LoggerFactory.getLogger(KafkaUserEventConsumer.class);

    @KafkaListener(topics = "user-events", groupId = "user-group")
    public void listen(UserMessageDTO message) {
        log.info("📩 Usuário recebido via Kafka: {}", message);
    }
}
