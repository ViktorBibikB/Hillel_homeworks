package logger.filelogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Properties;

public class FileLoggerConfigurationLoader {
    private static final String path = "property.properties";

    public static FileLoggerConfiguration load() {
        Properties properties = new Properties();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path));) {
            properties.load(bufferedReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String fileName = properties.getProperty("FILE");
        String level = properties.getProperty("LEVEL");
        String maxSize = properties.getProperty("MAX_SIZE");
        String format = properties.getProperty("FORMAT");

        validateValues(fileName, level, maxSize);
        return new FileLoggerConfiguration(fileName, LoggingLevel.valueOf(level), Integer.parseInt(maxSize), format);
    }

    private static void validateValues(String fileName, String level, String maxSize) {
        if (!Path.of(fileName).toAbsolutePath().startsWith((new File("")).getAbsolutePath())) {
            throw new RuntimeException("Path is not within project directory");
        }

        try {
            LoggingLevel.valueOf(level);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Incorrect value at " + level + ", must be " + Arrays.toString(LoggingLevel.values()), e);
        }

        try {
            Integer.parseInt(maxSize);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Impossible to convert " + maxSize + " to int", e);
        }
    }

}
