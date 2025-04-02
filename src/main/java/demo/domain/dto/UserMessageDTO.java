package demo.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserMessageDTO(UUID id, LocalDateTime createdAt) {
}
