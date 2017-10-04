package ru.clubbreakfast.at_the_lecture.oct2.sockets.sckts;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ArrayList<Integer> users = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        try (ServerSocket s = new ServerSocket(8189)) {
            while (true) {
                Socket in = s.accept();
                Thread th = new Thread(() -> {
                    try (DataInputStream dis = new DataInputStream(in.getInputStream())) {
                        while (true) {
                            if (dis.available() > 0) {
                                String message = dis.readUTF();
                                System.out.println(message);
                                //hfpjckfnm dctv!
                            }
                        }
                    } catch (IOException e) { e.printStackTrace(); }
                });
                th.start();
            }
        }
    }

    public static void addUser(Integer port) {
        users.add((port));
    }
}
