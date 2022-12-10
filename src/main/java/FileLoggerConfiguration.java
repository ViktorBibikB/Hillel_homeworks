public class FileLoggerConfiguration {
    private final String path;
    private final LoggingLevel loggingLevel;
    private final int fileSize;
    private final String format;

    public FileLoggerConfiguration(String path, LoggingLevel loggingLevel, int fileSize, String format) {
        this.path = path;
        this.loggingLevel = loggingLevel;
        this.fileSize = fileSize;
        this.format = format;
    }

    public String getPath() {
        return path;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public int getFileSize() {
        return fileSize;
    }

    public String getFormat() {
        return format;
    }
}
