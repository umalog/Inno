package ru.clubbreakfast.at_the_lecture.oct2.sockets.broadcast;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class BroadcastServer {
    static Boolean isStoped = false;
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5070);
            while (!isStoped) {
                startChat(serverSocket.accept());
            }
            serverSocket.close();//!!!      спросить законно ли это!!!
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startChat(Socket socket) throws IOException {
        Thread th = new Thread(() -> {
            try(DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
                while (!isStoped) {
                    out.writeUTF(in.readUTF());
                    out.flush();
                }
                socket.close();//!!!        спросить законно ли это!!!
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        th.start();
    }
}
