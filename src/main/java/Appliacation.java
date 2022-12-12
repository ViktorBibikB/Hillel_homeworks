import logger.FileLogger;
import logger.FileLoggerConfiguration;
import logger.FileLoggerConfigurationLoader;

public class Appliacation {
    private final static String PATH = "property.properties";

    public static void main(String[] args) {
        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader(PATH);
        FileLoggerConfiguration config = loader.load();
        FileLogger fileLogger = new FileLogger(config);
        fileLogger.debug("Hello world!");
        fileLogger.debug("Hello world!");
        fileLogger.info("info message");
    }
}
