package clientModule.src.main.java.demoClient;

public class Main {

    public static void main(String[] args) {
        try {
            new Client("localhost", 8080).start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
