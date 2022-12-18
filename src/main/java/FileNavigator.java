import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.util.*;

public class FileNavigator {
    private Map<String, List<FileData>> fileMap = new LinkedHashMap<>();

    public void add(String path, FileData fileData) {
        if (!fileData.getFilePath().equals(path))
            throw new IllegalArgumentException("Path " + path + " does not equals fileData path: " + fileData.getFilePath());

        if (fileMap.containsKey(path))
            fileMap.get(path).add(fileData);
        else {
            List<FileData> fileDataList = new ArrayList<>();
            fileDataList.add(fileData);
            fileMap.put(path, fileDataList);
        }
    }

    public List<FileData> find(String path) {
        return fileMap.get(path);
    }

    public List<FileData> filterBySize(int size) {
        List<FileData> fileDataList = new ArrayList<>();

        for (Map.Entry<String, List<FileData>> entry : fileMap.entrySet()) {
            for (FileData fileData : fileDataList) {
                if (fileData.getFileSize() >= size)
                    fileDataList.add(fileData);
            }
        }

        return fileDataList;
    }

    public void remove(String path) {
        fileMap.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> fileDataList = new ArrayList<>();

        for (Map.Entry<String, List<FileData>> entry : fileMap.entrySet()) {
            fileDataList.addAll(entry.getValue());
        }
        fileDataList.sort(Comparator.comparingLong(FileData::getFileSize));

        return fileDataList;
    }

    public void add_v2(String fileName) {
        try {
            File file = createFile(fileName);

            FileData fileData = new FileData(file.getName(), (int) (Math.random() * 1024), file.getParent());

            if (!fileData.getFilePath().equals(file.getParent()))
                throw new IllegalArgumentException("Path " + fileName + " does not equals fileData path: " + fileData.getFilePath());

            if (fileMap.containsKey(fileName))
                fileMap.get(fileName).add(fileData);
            else {
                List<FileData> fileDataList = new ArrayList<>();
                fileDataList.add(fileData);
                fileMap.put(fileName, fileDataList);
            }
        } catch (FileSystemException e) {
            e.printStackTrace();
            e.getMessage();
        }


    }

    private File createFile(String fileName) throws FileSystemException {
        File absolutePath = new File("C:\\Users\\viktor.bibik\\IdeaProjects\\Hilley\\Group_21.10.2022\\HomeWorks\\HW_13");
        File file = new File(absolutePath + "\\" + fileName);

        if (file.isDirectory())
            throw new FileSystemException("Instead of file was created a directory.");

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
