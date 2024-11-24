package org.moldavets.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.moldavets.model.Racer;
import org.moldavets.model.input.InputData;
import org.moldavets.model.input.RacerRecord;
import org.moldavets.model.input.TimeRecord;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelBuilderImplTest {
    @Mock
    private ModelBuilderImpl modelBuilder;

    @BeforeEach
    void setUp() {
        modelBuilder = new ModelBuilderImpl();
    }

    @Test
    void modelBuilderImpl_shouldBuildCorrectRacerModel_whenInputDataIsCorrect() {
        TimeRecord start = new TimeRecord("1", LocalDateTime.of(2024,8,16,10,0,0));
        TimeRecord end = new TimeRecord("1", LocalDateTime.of(2024,8,16,10,5,0));

        RacerRecord racerRecord = new RacerRecord("1","John Doe","Red Bull");

        InputData inputData = new InputData(
                List.of(racerRecord),
                List.of(start),
                List.of(end)

        );


        Collection<Racer> racers = modelBuilder.build(inputData);

        assertEquals(1, racers.size());
        Racer racer = racers.iterator().next();
        assertEquals("1", racer.key());
        assertEquals("John Doe", racer.name());
        assertEquals("Red Bull", racer.team());

        assertEquals(start.timestamp(), racer.startTimeStamp());
        assertEquals(end.timestamp(), racer.endTimeStamp());

    }

    @Test
    void modelBuilderImpl_shouldReturnEmptyRacersCollection_whenInputDataIsEmpty () {
        InputData inputData = new InputData(
                List.of(),
                List.of(),
                List.of()
        );

        Collection<Racer> racers = modelBuilder.build(inputData);

        assertTrue(racers.isEmpty());
    }


    @Test
    void modelBuilderImpl_shouldReturnException_whenInputDataNotContainsTimeRecord () {
        RacerRecord racerRecord = new RacerRecord("1","John Doe","Red Bull");

        InputData inputData = new InputData(
                List.of(racerRecord),
                List.of(),
                List.of()

        );

        RuntimeException exception = assertThrows(RuntimeException.class, () -> modelBuilder.build(inputData));
        assertEquals("Invalid data for key = 1 - null", exception.getMessage());
    }

    @Test
    void modelBuilderImpl_shouldReturnException_whenInputNotContainsSecondTimeRecord () {
        TimeRecord startTime = new TimeRecord("1", LocalDateTime.of(2024,8,16,10,0,0));
        RacerRecord racerRecord = new RacerRecord("1","John Doe","Red Bull");

        InputData inputData = new InputData(
                List.of(racerRecord),
                List.of(startTime),
                List.of()

        );

        RuntimeException exception = assertThrows(RuntimeException.class, () -> modelBuilder.build(inputData));

        assertEquals("Invalid data for key = 1 - [TimeRecord[key=1, timestamp=2024-08-16T10:00]]", exception.getMessage());
    }

    @Test
    void modelBuilderImpl_shouldReturnException_whenInputContainsInvalidRacerKey () {
        TimeRecord startTime = new TimeRecord("2", LocalDateTime.of(2024,8,16,10,0,0));
        TimeRecord endTime = new TimeRecord("2", LocalDateTime.of(2024,8,16,10,5,0));

        RacerRecord racerRecord = new RacerRecord("1","John Doe","Red Bull");

        InputData inputData = new InputData(
                List.of(racerRecord),
                List.of(startTime),
                List.of(endTime)
        );

        RuntimeException exception = assertThrows(RuntimeException.class, () -> modelBuilder.build(inputData));

        assertEquals("Invalid data for key = 1 - null", exception.getMessage());


    }
}