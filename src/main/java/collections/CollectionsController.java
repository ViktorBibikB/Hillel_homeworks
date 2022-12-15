package collections;

import java.util.ArrayList;
import java.util.List;

public class CollectionsController {
    public static int countOccurance(List<String> stringList, String text) {
        int counter = 0;
        for (String l : stringList) {
            if (l.equals(text))
                counter++;
        }
        System.out.printf("Word \"%s\" occurs - %d times. %n", text, counter);
        return counter;
    }

    public static List<Integer> toList(int[] arr) {
        List<Integer> integerList = new ArrayList<>();
        for (int i :
                arr) {
            integerList.add(i);
        }
        return integerList;
    }

    public static List<Integer> findUnique(List<Integer> integerList) {
        List<Integer> newList = new ArrayList<>();

        for (Integer integer : integerList) {
            if (newList.contains(integer))
                continue;
            newList.add(integer);
        }

        return newList;
    }

    public static void calcOccurance(List<String> stringList) {
        for (String unique : findUniqueString(stringList)) {
            countOccurance(stringList, unique);
        }
    }

    public static List<StringOccurrences> findOccurrence(List<String> strings) {
        List<StringOccurrences> occurrences = new ArrayList<>();

        for (String unique : findUniqueString(strings)) {
            occurrences.add(new StringOccurrences(unique, countOccurance(strings, unique)));
        }
        return occurrences;
    }

    private static List<String> findUniqueString(List<String> stringList) {
        List<String> newStringList = new ArrayList<>();

        for (String unique : stringList) {
            if (newStringList.contains(unique)) {
                continue;
            }
            newStringList.add(unique);
        }
        return newStringList;
    }
}
