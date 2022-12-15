import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static collections.CollectionsController.*;


public class Application {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("text.txt"));) {
            List<String> stringList = new ArrayList<>(Arrays.asList(bufferedReader.readLine().split(" ")));

            countOccurance(stringList, "Lorem");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] arr = {1, 2, 3, 5, 8, -5, 548};
        System.out.println(toList(arr));

        List<Integer> integerList = Arrays.asList(1, 5, 1, 8, 5, 3, 9);
        System.out.println(findUnique(integerList));

        List<String> strings = new ArrayList<>();
        strings.add("bird");
        strings.add("bird");
        strings.add("cat");
        strings.add("fox");
        strings.add("bird");
        strings.add("fox");

        calcOccurance(strings);
        System.out.println(findOccurrence(strings));
    }
}
