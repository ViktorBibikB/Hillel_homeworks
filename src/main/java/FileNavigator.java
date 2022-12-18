import java.io.File;
import java.io.IOException;
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
            for (FileData fileData : entry.getValue()) {
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

    public void add_v2(String path) {
        try {
            File file = createFile(path);

            FileData fileData = new FileData(file.getName(), (int) (Math.random() * 1024), file.getParent());

            if (!fileData.getFilePath().equals(file.getParent()))
                throw new IllegalArgumentException("Path " + path + " does not equals fileData path: " + fileData.getFilePath());

            if (fileMap.containsKey(path))
                fileMap.get(path).add(fileData);
            else {
                List<FileData> fileDataList = new ArrayList<>();
                fileDataList.add(fileData);
                fileMap.put(path, fileDataList);
            }
        } catch (FileIsDirectoryException e) {
            e.printStackTrace();
        }


    }

    private File createFile(String path) throws FileIsDirectoryException {
        File directory = new File(path);

        if(!directory.isDirectory()){
            directory.mkdirs();
        }

        File file = new File(directory + "\\" + "testFile.txt");

        if (file.isDirectory())
            throw new FileIsDirectoryException("Instead of file was created a directory.");

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
