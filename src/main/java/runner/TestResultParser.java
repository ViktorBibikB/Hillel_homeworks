package runner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TestResultParser {
    public TestResult parser(Path path) {
        int totalTestsCount = 0;
        int passedTestsCount = 0;
        int failedTestsCount = 0;
        int testTime = 0;

        try (Scanner reader = new Scanner(path)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();

                if (line.contains("[         ")) {
                    String[] lines = line.split("\\[         ");
                    String[] separated = lines[1].split(" ", 2);
                    String count = separated[0];
                    String type = separated[1];
                    if (type.contains("tests found")) {
                        totalTestsCount = Integer.parseInt(count);
                    } else if (type.contains("tests successful")) {
                        passedTestsCount = Integer.parseInt(count);
                    }
                }
                if (line.contains("Test run finished")) {
                    String time = line.substring(24, line.lastIndexOf(" "));
                    testTime = Integer.parseInt(time);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new TestResult(totalTestsCount, passedTestsCount, failedTestsCount, testTime);
    }

    public TestResult parser(String stringPath) {
        return parser(Paths.get(stringPath));
    }

    public TestResult parser(File file) {
        return parser(file.getPath());
    }


}
