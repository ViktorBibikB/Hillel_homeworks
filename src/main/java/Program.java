public class Program {
    private static final String TXT_FILE_PATH = "path\\to\\file";
    private static final String JAVA_FILE_PATH = "path\\to\\javaFile";

    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        fileNavigator.add_v2(TXT_FILE_PATH);
        fileNavigator.add_v2(TXT_FILE_PATH);
        fileNavigator.add_v2(TXT_FILE_PATH);
        fileNavigator.add_v2(TXT_FILE_PATH);

        System.out.println(fileNavigator.find(TXT_FILE_PATH));
        System.out.println(fileNavigator.filterBySize(512));
        System.out.println(fileNavigator.sortBySize());
        fileNavigator.remove(TXT_FILE_PATH);
        System.out.println(fileNavigator.find(TXT_FILE_PATH));
    }
}
