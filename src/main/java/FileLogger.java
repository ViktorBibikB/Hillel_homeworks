import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FileLogger {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss.SSS");
    private final FileLoggerConfiguration config;
    File file;

    private String path;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
        path = buildFilePath();
        file = new File(config.getPath());
    }

    public void debug(String message) {
        if (config.getLoggingLevel().equals(LoggingLevel.INFO)) {
            return;
        }

        long messageSize = message.getBytes().length;
        if (messageSize > config.getSizeLimit()) {
            throw new RuntimeException("Message is too large");
        }

        if (file.length() + messageSize < config.getSizeLimit()) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
                bufferedWriter.write(message);
            } catch (IOException e) {
                throw new RuntimeException("Failed to write message", e);
            }
        } else throw new RuntimeException("File size is exceeded");

        buildMessage(message, LoggingLevel.DEBUG);
    }

    private String buildFilePath() {
        return config.getPath() + "_" + FORMATTER.format(LocalDateTime.now());
    }

    private String buildMessage(String message, LoggingLevel level) {
        return String.format(config.getFormat(), FORMATTER.format(LocalDateTime.now()), level.name(), message);
    }
}
