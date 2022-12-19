import java.io.File;
import java.io.IOException;

public class Program {
    private static final String TXT_FILE_PATH = "home\\hillel\\files\\test1.txt";
    private static final String JAVA_FILE_PATH = "path\\to\\javaFile";

    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        fileNavigator.add("home\\hillel\\files\\test1.txt");
        fileNavigator.add("home\\hillel\\files\\test2.txt");
        fileNavigator.add("home\\hillel\\files\\test3.txt");
        fileNavigator.add("home\\hillel\\files\\test4.txt");

        System.out.println(fileNavigator.find("home\\hillel\\files"));
        System.out.println(fileNavigator.filterBySize(512));
        System.out.println(fileNavigator.sortBySize());
        fileNavigator.remove("home\\hillel\\files");
        System.out.println(fileNavigator.find("home\\hillel\\files"));
    }
}
