package meth.actions;

import logger.filelogger.FileLogger;
import logger.filelogger.FileLoggerConfiguration;
import logger.filelogger.FileLoggerConfigurationLoader;
import logger.filelogger.LoggingLevel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.util.Properties;

public class FileLoggerTest {
    FileLogger fileLogger;
    FileLoggerConfiguration config;
    FileLoggerConfigurationLoader configurationLoader;
    File file;

    @BeforeEach
    public void setup(){
        configurationLoader = Mockito.mock();
        config = Mockito.mock(FileLoggerConfiguration.class);
        fileLogger = new FileLogger(config);
    }

    @Test
    public void debug_success(){
        fileLogger.debug("Debug text");
    }
}
