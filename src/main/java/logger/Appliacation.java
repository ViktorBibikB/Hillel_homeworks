package logger;

import logger.filelogger.FileLogger;
import logger.filelogger.FileLoggerConfiguration;
import logger.filelogger.FileLoggerConfigurationLoader;

public class Appliacation {
    public static void main(String[] args) {;
        FileLoggerConfiguration config = FileLoggerConfigurationLoader.load();
        FileLogger fileLogger = new FileLogger(config);
        fileLogger.debug("Hello world!");
        fileLogger.debug("Hello world!");
        fileLogger.info("info message");
    }
}
