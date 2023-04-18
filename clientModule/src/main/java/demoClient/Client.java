package clientModule.src.main.java.demoClient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client implements AutoCloseable {
    private Socket socket;
    private BufferedWriter writer;
    private BufferedReader reader;
    private DataOutputStream dataOutputStream;
    private boolean isRunning = true;
    private Scanner scanner;

    private InputStream fileInputStream;

    public Client(String host, int port) {
        try {
            this.socket = new Socket(host, port);
            this.scanner = new Scanner(System.in);
            this.writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            this.reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Client() {
    }

    public void start() throws Exception {

        String response;
        while (isRunning) {
            try {
                String s = scanner.nextLine();
                handleRequest(s);
                response = reader.readLine();
                System.out.println(response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        close();
    }

    public void handleRequest(String s) throws IOException {
        if (s.startsWith("-file")) {
            sendFile(s);
        } else if (s.equalsIgnoreCase("-exit")) {
            sendMessage(s);
            isRunning = false;
        } else {
            sendMessage(s);
        }
    }


    void sendFile(String path) throws IOException {
        int bytes;
        String[] s1 = path.split(" ");
        if (s1.length > 1) {
            File file = new File(s1[1]);
            if (fileInputStream == null) {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (FileNotFoundException e) {
                    System.out.println("WRONG PATH");
                }
            }
            if (fileInputStream != null) {
                sendMessage(path);
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                // send file size
                dataOutputStream. writeLong(file.length());
                // break file into chunks
                byte[] buffer = new byte[4 * 1024];
                while ((bytes = fileInputStream.read(buffer)) != -1) {
                    dataOutputStream.write(buffer, 0, bytes);
                    dataOutputStream.flush();
                }
                fileInputStream.close();

            } else {
                sendMessage("I don't know where is my file...");
            }
        } else sendMessage("");
    }

    void sendMessage(String message) throws IOException {
        writer.write(message);
        writer.newLine();
        writer.flush();
    }

    @Override
    public void close() throws Exception {

        writer.close();
        reader.close();
        socket.close();
        if (dataOutputStream != null) {
            dataOutputStream.close();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public BufferedWriter getWriter() {
        return writer;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public DataOutputStream getDataOutputStream() {
        return dataOutputStream;
    }


    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setWriter(BufferedWriter writer) {
        this.writer = writer;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public void setDataOutputStream(DataOutputStream dataOutputStream) {
        this.dataOutputStream = dataOutputStream;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public InputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(InputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }
}