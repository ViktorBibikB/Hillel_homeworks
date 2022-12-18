public class Program {
    public static void main(String[] args) {
        final String TXT_FILE_PATH = "/path/to/file";
        final String JAVA_FILE_PATH = "/path/to/javaFile";
        String relativePath = "test.txt";

        FileNavigator fileNavigator = new FileNavigator();

        fileNavigator.add_v2(relativePath);
        fileNavigator.add_v2(relativePath);
        fileNavigator.add_v2(relativePath);
        fileNavigator.add_v2(relativePath);

//        fileNavigator.add(TXT_FILE_PATH, new FileData("file_01.txt", 64, TXT_FILE_PATH));
//        fileNavigator.add(TXT_FILE_PATH, new FileData("file_02.txt", 1024, TXT_FILE_PATH));
//        fileNavigator.add(TXT_FILE_PATH, new FileData("file_03.txt", 2048, TXT_FILE_PATH));
//
//        fileNavigator.add(JAVA_FILE_PATH, new FileData("file_04.java", 512, JAVA_FILE_PATH));
//        fileNavigator.add(JAVA_FILE_PATH, new FileData("file_05.java", 32, JAVA_FILE_PATH));
//        fileNavigator.add(JAVA_FILE_PATH, new FileData("file_06.java", 128, JAVA_FILE_PATH));
//
//        System.out.println(fileNavigator.find("/path/to/file"));
//        System.out.println(fileNavigator.find("/path/to/javaFile"));
//
//        System.out.println(fileNavigator.filterBySize(512));
//
//        System.out.println(fileNavigator.sortBySize());
//
//        fileNavigator.remove("/path/to/file");
//        System.out.println(fileNavigator.find("/path/to/file"));
    }
}
