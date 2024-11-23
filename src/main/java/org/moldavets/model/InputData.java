package org.moldavets.model;

import java.util.List;

public record InputData(
        List<RacerRecord> racerRecords,
        List<TimeRecord> starts,
        List<TimeRecord> ends
) {
}
