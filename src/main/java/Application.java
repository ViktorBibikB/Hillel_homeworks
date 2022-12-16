import phonebook.Record;
import phonebook.PhoneBook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static collections.CollectionsController.*;


public class Application {
    private static final String PATH_RECORDS = "RecordsListIncome.txt";
    private static final String PATH_TEXT = "text.txt";

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        for (Record record : createRecordListFromFile(PATH_RECORDS)) {
            phoneBook.add(record);
        }
        System.out.println(phoneBook.toString());

        System.out.println(phoneBook.find("Viktor"));
        System.out.println(phoneBook.find("Vladyslav"));
        System.out.println(phoneBook.find("Igor"));

        System.out.println(phoneBook.findAll("Viktor"));
        System.out.println(phoneBook.findAll("Vladyslav"));
        System.out.println(phoneBook.findAll("Tetyana"));



        findWordCountInFile(PATH_TEXT, "Lorem");

        int[] arr = {1, 2, 3, 5, 8, -5, 548};
        System.out.println(toList(arr));

        List<Integer> integerList = Arrays.asList(1, 5, 1, 8, 5, 3, 9, 5);
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

    private static void findWordCountInFile(String path, String word) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            List<String> stringList = new ArrayList<>(Arrays.asList(bufferedReader.readLine().split(" ")));

            countOccurance(stringList, word);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Record> createRecordListFromFile(String filePath) {
        List<Record> records = new ArrayList<>();
        String[] array;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.read() != -1) {
                array = reader.readLine().split("\n");

                for (String s : array) {
                    String[] ar = s.split(" ");
                    String name = ar[0];
                    String phone = ar[1];

                    records.add(new Record(name, phone));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
