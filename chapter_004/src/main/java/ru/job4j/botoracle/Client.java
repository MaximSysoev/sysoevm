package ru.job4j.botoracle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final Socket socket;
    private String ip;

    public Client(Socket socket, String ip) {
        this.socket = socket;
        this.ip = ip;
    }

    public void start() throws Exception {
        try {
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            Scanner console = new Scanner(System.in);
            String s;
            do {
                String str;
                s = console.nextLine();
                out.println(s);
                do {
                    str = in.readLine();
                    System.out.println(str);
                } while (!str.isEmpty());
            } while (!"exit".equals(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        try (final Socket socket = new ServerSocket(5001).accept()) {
            new Client( socket, "127.0.0.1").start();
        }

    }

}
