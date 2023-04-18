package serverModule.src.test.java.demo;

import org.junit.jupiter.api.*;


import java.io.*;
import java.net.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ServerTest {

    private Server server;
    private BufferedWriter writerMock;
    private BufferedReader readerMock;
    private DataInputStream dataInputStreamMock;
    private FileOutputStream fileOutputStreamMock;
    private List<Connection> connectionListMock;
    private ServerSocket serverSocketMock;
    private Socket clientSocketMock;
    private Connection connection;
    private Socket mockSocket1;
    private Socket mockSocket2;

    private List<Connection> connectionList;

    @BeforeEach
    void setUp() throws IOException {
        serverSocketMock = mock(ServerSocket.class);
        clientSocketMock = mock(Socket.class);
        writerMock = mock(BufferedWriter.class);
        when(serverSocketMock.accept()).thenReturn(clientSocketMock);

        server = new Server();
        server.setSocket(serverSocketMock);
        dataInputStreamMock = mock(DataInputStream.class);
        fileOutputStreamMock = mock(FileOutputStream.class);
        connectionListMock = spy(new ArrayList<>());
        connectionList = server.getConnectionList();
        mockSocket1 = mock(Socket.class);
        mockSocket2 = mock(Socket.class);
        when(mockSocket1.getOutputStream()).thenReturn(mock(OutputStream.class));
        when(mockSocket2.getOutputStream()).thenReturn(mock(OutputStream.class));

        readerMock = mock(BufferedReader.class);
        when(clientSocketMock.getInputStream()).thenReturn(mock(InputStream.class));
        when(clientSocketMock.getOutputStream()).thenReturn(mock(OutputStream.class));

    }

    @Test
    void testAddConnection() throws Exception {
        doNothing().when(writerMock).write(anyString());
        doNothing().when(writerMock).newLine();
        doNothing().when(writerMock).flush();
        when(readerMock.readLine()).thenReturn("-exit");

        server.setConnectionList(connectionListMock);
        server.handleConnection(clientSocketMock, writerMock, readerMock, dataInputStreamMock);


        verify(connectionListMock).add(any(Connection.class));
        verify(writerMock).write(anyString());
        verify(writerMock).newLine();
        verify(writerMock).flush();
        verify(writerMock).close();
        verify(readerMock).close();
    }

    @Test
    public void testCommandExit() throws Exception {

        doNothing().when(writerMock).write(anyString());
        doNothing().when(writerMock).newLine();
        doNothing().when(writerMock).flush();
        when(readerMock.readLine()).thenReturn("-exit");
        server.setConnectionList(connectionListMock);
        server.handleConnection(clientSocketMock, writerMock, readerMock, dataInputStreamMock);


        verify(connectionListMock).remove(any(Connection.class));
        verify(writerMock).write(anyString());
        verify(writerMock).newLine();
        verify(writerMock).flush();
        verify(writerMock).close();
        verify(readerMock).close();
    }


    @Test
    public void testReceiveFile() throws Exception {
        // Create test data
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        byte[] bytes = "hello, test test".getBytes();
        dataOutputStream.writeLong(bytes.length); // file size
        dataOutputStream.write(bytes);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        ByteArrayOutputStream fileOutputStream = new ByteArrayOutputStream();
        server.receiveFile(dataInputStream, fileOutputStream);

        // Verify output
        assertArrayEquals(bytes, fileOutputStream.toByteArray());
    }


    @Test
    public void sendMessage_shouldWriteMessageAndFlushWriter() throws IOException {

        Connection connection1 = new Connection(mockSocket1, 1);
        connectionList.add(connection1);
        connection1.setBufferedWriter(writerMock);

        Connection connection2 = new Connection(mockSocket2, 2);
        connectionList.add(connection2);
        connection2.setBufferedWriter(writerMock);

        connection = new Connection(mockSocket1, 4);

        // Act
        server.sendMessage("Hello, world!", writerMock);

        // Assert
        verify(writerMock).write("Hello, world!");
        verify(writerMock).newLine();
        verify(writerMock).flush();
    }

    @Test
    public void sendMessageOnConnect_shouldSendMessageToAllConnections() {
        // Arrange

        // Act
        server.sendMessageOnConnect(connection);

        // Assert
        for (Connection c : connectionList) {
            try {
                verify(c.getBufferedWriter(), times(2))
                        .write("[SERVER] " + connection.getName() + " success connected");
                verify(c.getBufferedWriter(), times(2)).newLine();
                verify(c.getBufferedWriter(), times(2)).flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void closeTest() throws Exception {
        server.close();

        verify(serverSocketMock).close();
    }



}

