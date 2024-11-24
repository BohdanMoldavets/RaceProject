package org.moldavets.utils;

import org.moldavets.model.Racer;

import java.time.Duration;
import java.util.function.Function;

public class RacerUtils {

    public static Function<Racer, Duration> lapDuration = racer -> Duration.between(racer.startTimeStamp(), racer.endTimeStamp());

    public static Function<Duration, String> durationFormat = duration -> "%02d:%02d:%03d".formatted(duration.toMinutesPart(), duration.toSecondsPart(), duration.toMillisPart());

}
