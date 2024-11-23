package org.moldavets.mapper;

import org.moldavets.model.TimeRecord;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.function.Function;

public class TimeRecordMapper implements Function<String, TimeRecord> {

    @Override
    public TimeRecord apply(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Time record is null or empty");
        }
        String key = s.substring(0, 3);
        String tempTimeString = s.substring(3).replace('_', 'T');
        try {
            LocalDateTime timestamp = LocalDateTime.parse(tempTimeString);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid time format");
        }
        LocalDateTime timestamp = LocalDateTime.parse(tempTimeString);
        return new TimeRecord(key, timestamp);
    }
}
