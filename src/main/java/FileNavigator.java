import java.util.*;

public class FileNavigator {
    private Map<String, List<FileData>> fileMap = new LinkedHashMap<>();

    public void add(String path, FileData fileData) {
        if(!fileData.getFilePath().equals(path))
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

}
