package org.moldavets.mapper;

import org.junit.jupiter.api.Test;
import org.moldavets.model.input.TimeRecord;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TimeRecordMapperTest {
    TimeRecordMapper mapper = new TimeRecordMapper();

    @Test
    void timeRecordMapper_shouldReturnException_whenInputIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> mapper.apply(null));
    }

    @Test
    void timeRecordMapper_shouldReturnException_whenInputIsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> mapper.apply(""));
    }

    @Test
    void timeRecordMapper_shouldReturnException_whenInputContainsNotTwoArguments() {
        String input = "SVF_2018-05-24_12:02:58.917";
        assertThrows(IllegalArgumentException.class,
                () -> mapper.apply(input));
    }

    @Test
    void timeRecordMapper_shouldReturnValidData_whenInputContainsValidFormat() {
        String inputString = "SVF2018-05-24_12:02:58.917";
        LocalDateTime inputDate = LocalDateTime.parse("2018-05-24T12:02:58.917");
        TimeRecord expected = new TimeRecord("SVF", inputDate);

        TimeRecord actual = mapper.apply(inputString);

        assertEquals(expected, actual);
    }

    @Test
    void timeRecordMapper_shouldReturnException_whenInputContainsEmptyPartsInRecord() {
        String input = "SVF_12:02:58.917";
        assertThrows(IllegalArgumentException.class,
                () -> mapper.apply(input));
    }
}