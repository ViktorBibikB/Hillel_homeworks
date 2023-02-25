package logger.filelogger;

import logger.exceptions.FileMaxSizeReachedException;
import logger.logger.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FileLogger implements Logger {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss.SSS");
    private final FileLoggerConfiguration config;
    private final File file;


    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
        file = new File(buildFilePath());
    }

    public void debug(String message) {
        if (config.getLoggingLevel().equals(LoggingLevel.INFO)) {
            return;
        }

        try {
            log(buildMessage(message, LoggingLevel.DEBUG));
        } catch (FileMaxSizeReachedException e) {
            e.printStackTrace();
        }
    }

    public void info(String message) {
        try {
            log(buildMessage(message, LoggingLevel.INFO));
        } catch (FileMaxSizeReachedException e) {
            e.printStackTrace();
        }
    }

    private String buildFilePath() {
        return config.getPath() + "_" + FORMATTER.format(LocalDateTime.now()).replace(':', '_');
    }

    private String buildMessage(String message, LoggingLevel level) {
        return String.format(config.getFormat(), FORMATTER.format(LocalDateTime.now()), level.name(), message);
    }

    private void write(File file, String message) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(message);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write message", e);
        }
    }

    private void log(String message) throws FileMaxSizeReachedException {
        long messageSize = message.getBytes().length;
        if (messageSize > config.getSizeLimit()) {
            throw new FileMaxSizeReachedException("Message is too large.");
        }

        if (file.length() + messageSize < config.getSizeLimit()) {
            write(file, message);
        } else
            throw new FileMaxSizeReachedException("File size is exceeded. Max size is " + config.getSizeLimit() + " bytes.");


    }
}
