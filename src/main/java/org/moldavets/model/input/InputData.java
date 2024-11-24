package org.moldavets.model.input;

import java.util.List;

public record InputData(
        List<RacerRecord> racerRecords,
        List<TimeRecord> starts,
        List<TimeRecord> ends
) {
}
