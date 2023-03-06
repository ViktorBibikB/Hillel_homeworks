import tests.mathactions.ArrayActionsTest;
import tests.mathactions.SimpleMathLibraryTest;

public class Main {
    public static void main(String[] args) {
        ProjectTestRunner projectTestRunner = new ProjectTestRunner();
//        projectTestRunner.runByPackageName("tests.mathactions");
//        projectTestRunner.runByClassName("tests.mathactions.ArrayActionsTest");
//        projectTestRunner.runByClass(SimpleMathLibraryTest.class);
//        projectTestRunner.runByClasses(SimpleMathLibraryTest.class, ArrayActionsTest.class);
        projectTestRunner.runByClassesNames("tests.mathactions.ArrayActionsTest", "tests.mathactions.SimpleMathLibraryTest");
    }
}
