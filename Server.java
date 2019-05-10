package ru.job4j.inputouput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void start(int port) throws Exception {
        try {
            ServerSocket servSocket =  new ServerSocket(port);
            System.out.print("Ждём подключения к серверу");
            Socket socket = servSocket.accept();
            System.out.println("Подключение состоялось");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            do {
                System.out.println("wait command ...");
                String ask = in.readLine();
                System.out.println(ask);
                if ("hello".equals(ask)) {
                    out.println("Hello, dear friend, I'm a oracle.");
                    out.println();
                }
            } while ("exit".equals(in.readLine()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
      // Server server = new Server();
      //  server.start(500);
        int port = 5000;
        try {
            ServerSocket servSocket =  new ServerSocket(port);
            System.out.print("Ждём подключения к серверу");
            Socket socket = servSocket.accept();
            System.out.println("Подключение состоялось");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
