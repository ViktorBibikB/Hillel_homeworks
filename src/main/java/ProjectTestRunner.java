import org.junit.platform.console.ConsoleLauncher;

import java.io.*;

public class ProjectTestRunner {
    public void runByPackageName(String packageName){
        PrintStream print = System.out;
        PrintStream printErr = System.err;
        ConsoleLauncher.execute(print, printErr, String.format("-p %s", packageName));

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.format("%s.txt", packageName), true))) {
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            ConsoleLauncher.execute(printWriter, printWriter, String.format("-p %s", packageName));
        } catch (IOException e) {
            throw new RuntimeException("Failed to write message", e);
        }
    }

    public void runByClassName(String className){
        PrintStream print = System.out;
        PrintStream printErr = System.err;

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.format("%s.txt", className), true))) {
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            ConsoleLauncher.execute(printWriter, printWriter, String.format("-c %s", className));
            ConsoleLauncher.execute(print, printErr, String.format("-c %s", className));

        } catch (IOException e) {
            throw new RuntimeException("Failed to write message", e);
        }
    }

    public void runByClass(Class<?> aClass) {
        PrintStream print = System.out;
        PrintStream printErr = System.err;
        ConsoleLauncher.execute(print, printErr, String.format("-c %s", aClass.getName()));

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.format("%s.txt", aClass.getName()), true))) {
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            ConsoleLauncher.execute(printWriter, printWriter, String.format("-c %s", aClass.getName()));
        } catch (IOException e) {
            throw new RuntimeException("Failed to write message", e);
        }
    }

    public void runByClasses(Class<?>... aClass) {
        for (Class bClass: aClass) {
            PrintStream print = System.out;
            PrintStream printErr = System.err;

            ConsoleLauncher.execute(print, printErr, String.format("-c %s", bClass.getName()));

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.format("%s.txt", bClass.getName()), true))) {
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
                ConsoleLauncher.execute(printWriter, printWriter, String.format("-c %s", bClass.getName()));
            } catch (IOException e) {
                throw new RuntimeException("Failed to write message", e);
            }
        }
    }
    public void runByClassesNames(String... className) {
        for (String bClass: className) {
            PrintStream print = System.out;
            PrintStream printErr = System.err;

            ConsoleLauncher.execute(print, printErr, String.format("-c %s", bClass));

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.format("%s.txt", bClass), true))) {
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
                ConsoleLauncher.execute(printWriter, printWriter, String.format("-c %s", bClass));
            } catch (IOException e) {
                throw new RuntimeException("Failed to write message", e);
            }
        }
    }
}
