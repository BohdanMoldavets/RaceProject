package org.moldavets.service;

import org.moldavets.model.input.InputData;

public interface InputDataReader {
    InputData readInputData(String racersFileName, String startsFileName, String endsFileName);
}
