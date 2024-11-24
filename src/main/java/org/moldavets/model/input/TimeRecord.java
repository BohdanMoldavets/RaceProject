package org.moldavets.model.input;

import java.time.LocalDateTime;

public record TimeRecord(
        String key,
        LocalDateTime timestamp
) {
}
