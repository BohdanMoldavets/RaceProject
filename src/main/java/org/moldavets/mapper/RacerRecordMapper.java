package org.moldavets.mapper;

import org.moldavets.model.RacerRecord;

import java.util.function.Function;

public class RacerRecordMapper implements Function<String, RacerRecord> {

    @Override
    public RacerRecord apply(String s) {
        if(s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Record is null or empty");
        }
        String[] racerRecordPartsArray =  s.split("_");
        if(racerRecordPartsArray.length != 3) {
            throw new IllegalArgumentException("Invalid record format");
        }

        for(int i = 0; i < racerRecordPartsArray.length; i++) {
            if(racerRecordPartsArray[i].isEmpty()) {
                throw new IllegalArgumentException("Invalid record format");
            }
        }
        return new RacerRecord(racerRecordPartsArray[0],racerRecordPartsArray[1],racerRecordPartsArray[2]);
    }
}
