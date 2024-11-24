package org.moldavets.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.moldavets.model.Racer;
import org.moldavets.model.table.TableOptions;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TableBuilderImplTest {
    @Mock
    private final TableBuilderImpl tableBuilder = new TableBuilderImpl();

    @Test
    void tableBuilderImpl_shouldBuildTableWithCorrectData_whenInputContainsCorrectData() {
        LocalDateTime startTimeForFirstRacer = LocalDateTime.of(2024,8,16,10,0,0);
        LocalDateTime endTimeForFirstRacer = LocalDateTime.of(2024,8,16,10,5,20);

        LocalDateTime startTimeForSecondRacer = LocalDateTime.of(2024,8,16,10,5,0);
        LocalDateTime endTimeForSecondRacer = LocalDateTime.of(2024,8,16,10,10,20);



        Collection<Racer> racers = List.of(
                new Racer("1","John Doe", "Red bull", startTimeForFirstRacer, endTimeForFirstRacer),
                new Racer("2", "Jack Doom", "Pepsi", startTimeForSecondRacer, endTimeForSecondRacer)
        );


        TableOptions<Racer> tableOptions = TableOptions.racerOptions();
        String table = tableBuilder.build(racers, tableOptions);
        String expected = """
                |No|Name     |Team    |Lap time |
                |1 |John Doe |Red bull|05:20:000|
                |2 |Jack Doom|Pepsi   |05:20:000|""";

        assertEquals(expected.trim(), table.trim());
    }

    @Test
    void tableBuilderImpl_shouldBuildLongTableWithCorrectData_whenInputContainsOneLongNameInData() {
        LocalDateTime startTimeForFirstRacer = LocalDateTime.of(2024,8,16,10,0,0);
        LocalDateTime endTimeForFirstRacer = LocalDateTime.of(2024,8,16,10,5,20);

        LocalDateTime startTimeForSecondRacer = LocalDateTime.of(2024,8,16,10,5,0);
        LocalDateTime endTimeForSecondRacer = LocalDateTime.of(2024,8,16,10,10,20);



        Collection<Racer> racers = List.of(
                new Racer("1","John Doegadsasdgsdfsdfsdfsdfsdfsdfsdfsdfsdfsdgdfgdfghdfg", "Red bull", startTimeForFirstRacer, endTimeForFirstRacer),
                new Racer("2", "Jack Doom", "Pepsi", startTimeForSecondRacer, endTimeForSecondRacer)
        );


        TableOptions<Racer> tableOptions = TableOptions.racerOptions();
        String table = tableBuilder.build(racers, tableOptions);
        String expected = """
                |No|Name                                                    |Team    |Lap time |
                |1 |John Doegadsasdgsdfsdfsdfsdfsdfsdfsdfsdfsdfsdgdfgdfghdfg|Red bull|05:20:000|
                |2 |Jack Doom                                               |Pepsi   |05:20:000|""";

        assertEquals(expected.trim(), table.trim());
    }

    @Test
    void tableBuilderImpl_shouldBuildLongTableWithCorrectData_whenInputContainsLongTeamNameInData() {
        LocalDateTime startTimeForFirstRacer = LocalDateTime.of(2024,8,16,10,0,0);
        LocalDateTime endTimeForFirstRacer = LocalDateTime.of(2024,8,16,10,5,20);

        LocalDateTime startTimeForSecondRacer = LocalDateTime.of(2024,8,16,10,5,0);
        LocalDateTime endTimeForSecondRacer = LocalDateTime.of(2024,8,16,10,10,20);



        Collection<Racer> racers = List.of(
                new Racer("1","John Doe", "Red bullllllllllllllllllllllllllllllllllllllllllllllllllll", startTimeForFirstRacer, endTimeForFirstRacer),
                new Racer("2", "Jack Doom", "Pepsi", startTimeForSecondRacer, endTimeForSecondRacer)
        );


        TableOptions<Racer> tableOptions = TableOptions.racerOptions();
        String table = tableBuilder.build(racers, tableOptions);
        String expected = """
                |No|Name     |Team                                                      |Lap time |
                |1 |John Doe |Red bullllllllllllllllllllllllllllllllllllllllllllllllllll|05:20:000|
                |2 |Jack Doom|Pepsi                                                     |05:20:000|""";

        assertEquals(expected.trim(), table.trim());
    }


    @Test
    void tableBuilderImpl_shouldReturnEmptyTable_whenInputContainsEmptyCollection() {


        Collection<Racer> racers = List.of();


        TableOptions<Racer> tableOptions = TableOptions.racerOptions();
        String table = tableBuilder.build(racers, tableOptions);
        String expected = "|No|Name|Team|Lap time|";

        assertEquals(expected.trim(), table.trim());

    }


}