import java.util.Objects;

public class FileData implements Comparable<FileData> {
    private String fileName;
    private int fileSize;
    private String filePath;

    @Override
    public int compareTo(FileData o) {
        if (this.getFileSize() == o.getFileSize())
            return 0;
        else if (this.getFileSize() < o.getFileSize())
            return -1;
        else return 1;
    }

    public FileData(String fileName, int fileSize, String filePath) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileData)) return false;
        FileData fileData = (FileData) o;
        return getFileSize() == fileData.getFileSize() &&
                Objects.equals(getFileName(), fileData.getFileName()) &&
                Objects.equals(getFilePath(), fileData.getFilePath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFileName(), getFileSize(), getFilePath());
    }

    @Override
    public String toString() {
        return "FileData{" +
                "fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", filePath='" + filePath + '\'' +
                '}' + "\n";
    }
}
