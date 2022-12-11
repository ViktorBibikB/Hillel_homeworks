import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Properties;

public class FileLoggerConfigurationLoader {
    private final String path;

    public FileLoggerConfigurationLoader(String path) {
        this.path = path;
    }

    public FileLoggerConfiguration load() {
        Properties properties = new Properties();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path));) {
            properties.load(bufferedReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String fileName = properties.getProperty("FILE");
        String level = properties.getProperty( "LEVEL");
        String maxSize = properties.getProperty( "MAX_SIZE");
        String format = properties.getProperty( "FORMAT");

        return new FileLoggerConfiguration(fileName, LoggingLevel.valueOf(level), Integer.parseInt(maxSize), format);
    }

}
