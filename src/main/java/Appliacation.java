import filelogger.FileLogger;
import filelogger.FileLoggerConfiguration;
import filelogger.FileLoggerConfigurationLoader;

public class Appliacation {
    private final static String PATH = "property.properties";

    public static void main(String[] args) {;
        FileLoggerConfiguration config = FileLoggerConfigurationLoader.load();
        FileLogger fileLogger = new FileLogger(config);
        fileLogger.debug("Hello world!");
        fileLogger.debug("Hello world!");
        fileLogger.info("info message");
    }
}
