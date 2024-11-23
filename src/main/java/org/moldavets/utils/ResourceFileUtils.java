package org.moldavets.utils;

import java.io.*;
import java.util.List;
import java.util.function.Function;

public class ResourceFileUtils {

    public static <T> T readResourceFile(String fileName, Function<InputStream, T> mapper) {
        try (InputStream stream = ResourceFileUtils.class.getClassLoader().getResourceAsStream(fileName)){
            if (stream == null) {
                throw new FileNotFoundException("File not found " + fileName);
            }
            return mapper.apply(stream);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static <T> List<T> readResourceFileToList(String fileName, Function<String, T> mapper) {
        return readResourceFile(fileName,(inputStream -> {
                    try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                         BufferedReader reader = new BufferedReader(inputStreamReader)) {
                        return reader.lines().map(mapper).toList();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
        );
    }


}
