package ru.clubbreakfast.at_the_lecture.oct2.sockets.broadcast;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",5070);
            send(new DataOutputStream(socket.getOutputStream()));
            DataInputStream in = new DataInputStream(socket.getInputStream());
            while (!BroadcastServer.isStoped){
                System.out.println(in.readUTF());
            }
            in.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void send(DataOutputStream out) throws IOException {

        while (!BroadcastServer.isStoped){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            out.writeUTF(reader.readLine());
            out.flush();
        }
        out.close();
    }
}
