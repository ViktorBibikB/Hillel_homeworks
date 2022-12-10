import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//import static org.graalvm.compiler.nodes.extended.StoreHubNode.write;

public class FileLogger {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss.SSS");
    private final FileLoggerConfiguration config;
    private String path;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
        path = buildFilePath();
    }

    public void debug(String message) {
        if (config.getLoggingLevel().equals(LoggingLevel.INFO)) {
            return;
        }

//        File file = new File(path);
//        buildMessage(message, LoggingLevel.DEBUG);
        log(buildMessage(message, LoggingLevel.DEBUG));
    }

    public void info(String message) {
        log(buildMessage(message, LoggingLevel.INFO));
    }

    private String buildMessage(String message, LoggingLevel level) {
        return String.format(config.getFormat(), FORMATTER.format(LocalDateTime.now()), level.name(), message);
    }

    private String buildFilePath() {
        return config.getPath() + "_" + FORMATTER.format(LocalDateTime.now());
    }

    private void write(File file, String message) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(message);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write message", e);
        }
    }

    private void log(String message) {
        long messageSize = message.getBytes().length;
        if (messageSize > config.getFileSize()) {
            throw new RuntimeException("Message is too large");
        }

        File file = getFile();
        if (file.length() + messageSize < config.getFileSize()) {
//            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
//                bufferedWriter.write(message);
//            } catch (IOException e) {
//                throw new RuntimeException("Failed to write message", e);
//            }
            write(file, message);
        } else throw new RuntimeException("File size is exceeded");
    }

    private File getFile() {
        File file = new File(path);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            throw new RuntimeException("Failed to create file", e);
        }
    }
}
