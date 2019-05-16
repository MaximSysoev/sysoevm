package ru.job4j.botOracleTest;

import org.junit.Test;
import ru.job4j.botoracle.Server;
import ru.job4j.converter.Converter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.Socket;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;


public class ServerTest {

    @Test
    public void whenAskAnswerThenChooseRandom() throws Exception {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream("exit".getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.start();
        assertThat(out.toString(), is (""));
    }

}
