package org.moldavets.model;

import java.time.LocalDateTime;

public record TimeRecord(
        String key,
        LocalDateTime timestamp
) {
}
