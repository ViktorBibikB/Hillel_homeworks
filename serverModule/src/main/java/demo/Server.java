package serverModule.src.main.java.demo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server implements AutoCloseable {

    private List<Connection> connectionList;

    private ServerSocket serverSocket;
    private BufferedWriter writerEach;


    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        connectionList = new ArrayList<>();
    }

    public Server() {
        connectionList = new ArrayList<>();
    }

    public void setSocket(ServerSocket socket) {
        this.serverSocket = socket;
    }

    public void start() {
        while (!serverSocket.isClosed()) {
            run();
        }
    }


    void run() {
        try {
            Socket socket = serverSocket.accept();
            new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(socket.getOutputStream()));
                    DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                    handleConnection(socket, writer, reader, dataInputStream);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void handleConnection(Socket socket, BufferedWriter writer, BufferedReader reader,
                          DataInputStream dataInputStream) throws Exception {
        boolean isExit = false;
        Connection connection = new Connection(socket, connectionList.size());
        sendMessageOnConnect(connection);
        connectionList.add(connection);
        System.out.println(connectionList.size());


        while (!isExit) {
            String request = reader.readLine();
            System.out.println(request);
            if (request.equalsIgnoreCase("-exit")) {
                isExit = true;
                connectionList.remove(connection);
                sendMessage("BYE", writer);
            } else if (request.startsWith("-file")) {
                String[] s = request.split(" ");
                if (s.length > 0) {
                    String[] split = s[1].split("\\\\");
                    FileOutputStream fileOutputStream = new FileOutputStream(split[split.length - 1]);
                    receiveFile(dataInputStream, fileOutputStream);
                    sendMessage("SAVED", writer);
                }
            } else {
                sendMessage(request + "? What it means?", writer);
            }
        }
        reader.close();
        writer.close();
    }

    void receiveFile(DataInputStream dataInputStream, OutputStream fileOutputStream) throws Exception {
        int bytes;

        long size = dataInputStream.readLong();     // read file size
        byte[] buffer = new byte[4 * 1024];
        while (size > 0 && (bytes = dataInputStream.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
            fileOutputStream.write(buffer, 0, bytes);
            size -= bytes;      // read upto file size
        }
        fileOutputStream.close();
    }

    public void sendMessage(String message, BufferedWriter writer) throws IOException {
        writer.write(message);
        writer.newLine();
        writer.flush();
    }


    void sendMessageOnConnect(Connection connection) {
        for (Connection c : connectionList) {
            try {
                writerEach = c.getBufferedWriter();
                sendMessage("[SERVER] " + connection.getName() + " success connected", writerEach);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }


    @Override
    public void close() throws Exception {
        if (writerEach != null) writerEach.close();
        serverSocket.close();
    }

}


