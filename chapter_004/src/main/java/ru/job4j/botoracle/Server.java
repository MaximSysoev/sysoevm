package ru.job4j.botoracle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void start() throws Exception {
        try {
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            String ask;
            do {
                System.out.println("wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                if ("hello".equals(ask)) {
                    out.println("Hello, dear friend, I'm a oracle.");
                    out.println();
                } else {
                    out.println();
                }
            } while (!"exit".equals(ask));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        try (final Socket socket =  new ServerSocket(5000).accept()) {
            new Server(socket).start();
        }
    }
}
