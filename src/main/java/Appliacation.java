import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class Appliacation {
    private final static String PATH = "property.properties";


    public static void main(String[] args) {
        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader("test.txt");
        FileLoggerConfiguration config = loader.load();
        FileLogger fileLogger = new FileLogger(config);
        fileLogger.debug("Hello world!");
        fileLogger.debug("Hello world!");


//        fileLogger.info("info message");
//        try {
//            Properties properties = new Properties();
//            properties.load(new BufferedReader(new FileReader(PATH)));
//
//            File file = new File(properties.getProperty("FILE"));
//
//            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))){
//                bufferedWriter.write("Hello world!");
//            } catch (IOException e){
//                throw new RuntimeException("Failed to write message", e);
//            }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    private void write(File file, String message) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(message);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write message", e);
        }
    }
}
