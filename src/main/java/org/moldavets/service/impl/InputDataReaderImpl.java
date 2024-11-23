package org.moldavets.service.impl;

import org.moldavets.mapper.RacerRecordMapper;
import org.moldavets.mapper.TimeRecordMapper;
import org.moldavets.model.InputData;
import org.moldavets.service.InputDataReader;

import static org.moldavets.utils.ResourceFileUtils.readResourceFileToList;

public class InputDataReaderImpl implements InputDataReader {

    @Override
    public InputData readInputData(String racersFileName, String startsFileName, String endsFileName) {
        TimeRecordMapper timeRecordMapper = new TimeRecordMapper();
        return new InputData(
                readResourceFileToList(racersFileName, new RacerRecordMapper()),
                readResourceFileToList(startsFileName, timeRecordMapper),
                readResourceFileToList(endsFileName, timeRecordMapper)
        );
    }


}
