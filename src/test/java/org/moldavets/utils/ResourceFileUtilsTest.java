package org.moldavets.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.moldavets.utils.ResourceFileUtils.readResourceFile;

class ResourceFileUtilsTest {


    @Test
    void readResourceFile_shouldReturnException_whenInputDataDoesNotExist() {
        String fileName = "test.txt";

        ClassLoader classLoaderMock = mock(ClassLoader.class);
        when(classLoaderMock.getResourceAsStream(fileName)).thenReturn(null);

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> readResourceFile(fileName,inputStream -> null));

        assertEquals(exception.getMessage(),"File not found " + fileName);
    }


}