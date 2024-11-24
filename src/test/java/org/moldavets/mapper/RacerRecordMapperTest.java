package org.moldavets.mapper;

import org.junit.jupiter.api.Test;
import org.moldavets.model.input.RacerRecord;

import static org.junit.jupiter.api.Assertions.*;

class RacerRecordMapperTest {
    RacerRecordMapper mapper = new RacerRecordMapper();

    @Test
    void racerRecordMapper_shouldReturnException_whenInputIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> mapper.apply(null) );
    }

    @Test
    void racerRecordMapper_shouldReturnException_whenInputIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> mapper.apply(""));
    }

    @Test
    void racerRecordMapper_shouldReturnException_whenInputContainsNotThreeArguments() {
        String input = "JDO_John Doe Red Bull";
        assertThrows(IllegalArgumentException.class, () -> mapper.apply(input));
    }

    @Test
    void racerRecordMapper_shouldReturnValidData_whenInputContainsValidFormat() {
        String input = "JDO_John Doe_Red Bull";
        RacerRecord expected = new RacerRecord("JDO","John Doe","Red Bull");
        RacerRecord actual = mapper.apply(input);

        assertEquals(expected, actual);
    }

    @Test
    void racerRecordMapper_shouldReturnException_whenInputContainsEmptyPartsInRecord() {
        assertThrows(IllegalArgumentException.class, () -> mapper.apply("__D"));
    }
}