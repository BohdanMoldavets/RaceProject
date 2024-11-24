package org.moldavets.model;

import java.time.LocalDateTime;

public record Racer(
        String key,
        String name,
        String team,
        LocalDateTime startTimeStamp,
        LocalDateTime endTimeStamp

) {
}
