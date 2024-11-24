package org.moldavets.model.table;

import org.moldavets.model.Racer;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static org.moldavets.utils.RacerUtils.durationFormat;
import static org.moldavets.utils.RacerUtils.lapDuration;

public record TableOptions<T>(
        int separatorAfter,
        List<TableField<T>> fields,
        Comparator<T> sorting
) {
    public static TableOptions<Racer> racerOptions() {
        Function<Racer, String> counterFieldAccessor = new Function<>() {
            int count = 0;

            @Override
            public String apply(Racer racer) {
                return String.valueOf(++count);
            }
        };

        return new TableOptions<>(
                15,
                List.of(
                        new TableField<>("No", counterFieldAccessor),
                        new TableField<>("Name", Racer::name),
                        new TableField<>("Team", Racer::team),
                        new TableField<>("Lap time", lapDuration.andThen(durationFormat))
                ),
                Comparator.comparing(lapDuration)
        );
    }

}
