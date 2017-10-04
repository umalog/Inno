package ru.clubbreakfast.at_the_lecture.oct2.sockets.sckts;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    private static boolean isStoped = false;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4444);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

            new Thread(() -> {
                while (!isStoped) {
                    Scanner scanner = new Scanner(System.in);
                    String message = scanner.next();
                    if (message.equals("stop")) isStoped = true;
                    try {
                        out.writeUTF(message);
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            while (!isStoped){
                String txt = in.readLine();
                if (txt.equals("stop"))isStoped=true;
                System.out.println(txt);
            }

        }
        socket.close();
    }

}
