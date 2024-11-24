package org.moldavets.service.impl;

import org.moldavets.model.Racer;
import org.moldavets.model.input.InputData;
import org.moldavets.model.input.TimeRecord;
import org.moldavets.service.ModelBuilder;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModelBuilderImpl implements ModelBuilder {

    @Override
    public Collection<Racer> build(InputData inputData) {
        Map<String, List<TimeRecord>> timestampMap = Stream.concat(
                        inputData.starts().stream(),
                        inputData.ends().stream()
                ).sorted(Comparator.comparing(TimeRecord::timestamp))
                .collect(Collectors.groupingBy(TimeRecord::key, Collectors.toList()));
        return inputData.racerRecords().stream()
                .map(racerRecord -> {
                            List<TimeRecord> timestamps = timestampMap.get(racerRecord.key());
                            if(timestamps == null || timestamps.size() != 2) {
                                throw new RuntimeException("Invalid data for key = " + racerRecord.key() + " - " + timestamps);
                            }
                            return new Racer(
                                    racerRecord.key(),
                                    racerRecord.name(),
                                    racerRecord.team(),
                                    timestamps.get(0).timestamp(),
                                    timestamps.get(1).timestamp()
                            );
                        }
                ).collect(Collectors.toSet());
    }
}
