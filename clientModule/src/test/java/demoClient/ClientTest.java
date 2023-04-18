package clientModule.src.test.java.demoClient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ClientTest {
    @Mock
    private Socket socket;
    @Mock
    private BufferedWriter writer;
    @Mock
    private BufferedReader reader;
    @Mock
    private DataOutputStream dataOutputStream;

    @Mock
    private Scanner scanner;

    private Client client;
    @Mock
    private FileInputStream fileInputStream;

    @Captor
    private ArgumentCaptor<byte[]> bufferCaptor;


    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        client = new Client();
        client.setSocket(socket);
        client.setReader(reader);
        client.setWriter(writer);
        client.setScanner(scanner);

        when(socket.getOutputStream()).thenReturn(dataOutputStream);


    }

    @Test
    void testMessageSend() throws IOException {
        doNothing().when(writer).write(anyString());
        client.sendMessage(anyString());

        verify(writer).write(anyString());

        verify(writer).flush();
        verify(writer).newLine();
    }

    @Test
    void testCommandExit() throws IOException {
        client.handleRequest("-exit");

        verify(writer).write(anyString());
        verify(writer).flush();
        verify(writer).newLine();

    }

    @Test
    void testStartWhenRequestExit() throws Exception {
        when(scanner.nextLine()).thenReturn("-exit");
        when(reader.readLine()).thenReturn("BYE");

        client.start();

        assertFalse(client.isRunning());

        verify(socket).close();
    }

    @Test
    void testSendFile() throws Exception {
        String path = "-file /path/to/file.txt";

        // Mock file input stream
        InputStream fileInputStream = new ByteArrayInputStream("Hello, world!".getBytes());
        client.setFileInputStream(fileInputStream);

        // Call method under test
        client.sendFile(path);

        // Verify that the correct messages were sent to the server
        InOrder inOrder = inOrder(client.getWriter(), dataOutputStream);
        inOrder.verify(client.getWriter()).write(path);
        inOrder.verify(dataOutputStream).write(bufferCaptor.capture(), eq(0), eq(13));
        inOrder.verify(dataOutputStream).flush();

        // Verify that the buffer contained the expected data
        byte[] buffer = bufferCaptor.getValue();
        String actual = new String(buffer, 0, 13);
        Assertions.assertEquals("Hello, world!", actual);
    }


}


