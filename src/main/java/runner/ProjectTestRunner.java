package runner;

import org.junit.platform.console.ConsoleLauncher;

import java.io.*;

public class ProjectTestRunner {
    public void runByPackageName(String packageName){
        runConsoleAndWriteResult(packageName, "-p %s");
    }

    public void runByClassName(String className){
        runConsoleAndWriteResult(className, "-c %s");
    }

    public void runByClass(Class<?> aClass) {
        runConsoleAndWriteResult(aClass.getName(), "-c %s");
    }

    public void runByClasses(Class<?>... aClass) {
        for (Class bClass: aClass) {
            runConsoleAndWriteResult(bClass.getName(), "-c %s");
        }
    }
    public void runByClassesNames(String... className) {
        for (String bClass: className) {
            runConsoleAndWriteResult(bClass, "-c %s");
        }
    }

    private void runConsoleAndWriteResult(String coreName, String s) {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(bout);
        ConsoleLauncher.execute(printStream, printStream, String.format(s, coreName));

        String resultString = bout.toString();

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(String.format("%s.txt", coreName)));) {
            printWriter.println(resultString);

            printWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("Failed to write message", e);
        }
        System.out.println(resultString);
    }
}
