package ru.clubbreakfast.at_the_lecture.oct2.sockets.sckts;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

// 1 * 1
// многие ко многим
// комнаты
    /* Only TCP */

public class Client {
    private static int serverPort = 7777;
    private static String address = "127.0.0.1";
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(address, serverPort);
            System.out.println("I am gonna interact with Server");

            InputStream socketInputStream = socket.getInputStream();
            OutputStream socketOutputStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInputStream);
            DataOutputStream out = new DataOutputStream(socketOutputStream);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String messageText;

            while(true) {
                messageText = keyboard.readLine();
                System.out.println("Send to Server: " + messageText);
                out.writeUTF(messageText);
                out.flush();
                messageText = in.readUTF();
                System.out.println("Answer from Server: " + messageText);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
