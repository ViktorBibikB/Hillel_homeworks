package filelogger;

public class FileLoggerConfiguration {
    private final String path;
    private final LoggingLevel loggingLevel;
    private final int sizeLimit;
    private final String format;

    public FileLoggerConfiguration(String path, LoggingLevel loggingLevel, int sizeLimit, String format) {
        this.path = path;
        this.loggingLevel = loggingLevel;
        this.sizeLimit = sizeLimit;
        this.format = format;
    }

    public String getPath() {
        return path;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public int getSizeLimit() {
        return sizeLimit;
    }

    public String getFormat() {
        return format;
    }
}
