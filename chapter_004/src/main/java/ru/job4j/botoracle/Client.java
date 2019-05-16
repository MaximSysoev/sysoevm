package ru.job4j.botoracle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public void start(String ip, int port) throws Exception {
        try {
            Socket socket = new Socket(InetAddress.getByName(ip), port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
        new Client().start("127.0.0.1", 5001);
    }

}
