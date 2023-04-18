package serverModule.src.main.java.demo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Objects;

public class Connection {

    private Socket clientSocket;

    private BufferedWriter bufferedWriter;

    private String name;

    private LocalDateTime localDateTime;

    public Connection(Socket socket, int id) {
        id++;
        this.name = "Client-" + id;
        this.localDateTime = LocalDateTime.now();
        clientSocket = socket;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return Objects.equals(clientSocket, that.clientSocket) && Objects.equals(name, that.name) && Objects.equals(localDateTime, that.localDateTime);
    }

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public void setBufferedWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientSocket, name, localDateTime);
    }

    public String getName() {
        return name;
    }
}
