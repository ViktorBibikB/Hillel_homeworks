import java.io.File;
import java.io.IOException;

public class Program {

    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        fileNavigator.add("home\\hillel\\files\\test1.txt");
        fileNavigator.add("home\\hillel\\files\\test2.txt");
        fileNavigator.add("home\\hillel\\files\\test3.txt");
        fileNavigator.add("home\\hillel\\files\\test4.txt");

        System.out.println(fileNavigator.find("home\\hillel\\files"));
        System.out.println(fileNavigator.filterBySize(15));
        System.out.println(fileNavigator.sortBySize());
        fileNavigator.remove("home\\hillel\\files");
        System.out.println(fileNavigator.find("home\\hillel\\files"));
    }
}
