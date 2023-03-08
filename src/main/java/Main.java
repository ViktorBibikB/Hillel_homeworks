import runner.ProjectTestRunner;
import runner.TestResultParser;
import tests.mathactions.ArrayActionsTest;
import tests.mathactions.SimpleMathLibraryTest;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        ProjectTestRunner projectTestRunner = new ProjectTestRunner();
        projectTestRunner.runByPackageName("tests.mathactions");
        projectTestRunner.runByClassName("tests.mathactions.ArrayActionsTest");
        projectTestRunner.runByClass(SimpleMathLibraryTest.class);
        projectTestRunner.runByClasses(SimpleMathLibraryTest.class, ArrayActionsTest.class);
        projectTestRunner.runByClassesNames("tests.mathactions.ArrayActionsTest", "tests.mathactions.SimpleMathLibraryTest");

        TestResultParser testResultParser = new TestResultParser();
        Path path = Paths.get("tests.mathactions.ArrayActionsTest.txt");
        Path path2 = Paths.get("tests.mathactions.SimpleMathLibraryTest.txt");
        File file = new File(path2.toString());
        String path3 = file.getPath();
        System.out.println(testResultParser.parser(path));
        System.out.println(testResultParser.parser(file));
        System.out.println(testResultParser.parser(path3));
    }
}
