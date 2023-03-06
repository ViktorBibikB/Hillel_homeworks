import org.junit.platform.console.ConsoleLauncher;

import java.io.PrintStream;

public class ProjectTestRunner {
    public void runByPackageName(String packageName){
        PrintStream print = System.out;
        PrintStream printErr = System.err;

        ConsoleLauncher.execute(print, printErr, String.format("-p %s", packageName));
    }

    public void runByClassName(String className){
        PrintStream print = System.out;
        PrintStream printErr = System.err;

        ConsoleLauncher.execute(print, printErr, String.format("-c %s", className));
    }

    public void runByClass(Class<?> aClass) {
        PrintStream print = System.out;
        PrintStream printErr = System.err;

        ConsoleLauncher.execute(print, printErr, String.format("-c %s", aClass.getName()));
    }

    public void runByClasses(Class<?>... aClass) {
        for (Class bClass: aClass) {
            PrintStream print = System.out;
            PrintStream printErr = System.err;

            ConsoleLauncher.execute(print, printErr, String.format("-c %s", bClass.getName()));
        }
    }
    public void runByClassesNames(String... className) {
        for (String bClass: className) {
            PrintStream print = System.out;
            PrintStream printErr = System.err;

            ConsoleLauncher.execute(print, printErr, String.format("-c %s", bClass));
        }
    }
}
