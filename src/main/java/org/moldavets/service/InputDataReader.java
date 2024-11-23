package org.moldavets.service;

import org.moldavets.model.InputData;

public interface InputDataReader {
    InputData readInputData(String racersFileName, String startsFileName, String endsFileName);
}
