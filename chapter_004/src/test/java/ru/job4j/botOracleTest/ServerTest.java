package ru.job4j.botOracleTest;

import com.google.common.base.Joiner;
import org.junit.Test;
import ru.job4j.botoracle.Server;
import ru.job4j.converter.Converter;

import javax.sql.rowset.Joinable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.Socket;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;


public class ServerTest {

    private String LN = System.getProperty("line.separator");

    private void testServer(String input, String excepted) throws Exception {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(
                input.getBytes()
        );
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.start();
        assertThat(out.toString(), is (excepted));
    }

    @Test
    public void whenAskAnswerThenChooseRandom() throws Exception {
        this.testServer("exit", "\r\n");
    }

    @Test
    public void whenAskHelloThenGetGreeting() throws Exception {
        this.testServer(Joiner.on(LN).join(
                "hello",
                "exit"
        ),
         Joiner.on(LN).join(
            "Hello, dear friend, I'm a oracle.","", "", "")
         );
    }

}
