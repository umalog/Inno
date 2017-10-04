package ru.clubbreakfast.notMi.chat;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient implements Client {
    private volatile Socket socket;

    private class InputManager implements Runnable {
        private volatile Socket socket;

        public InputManager(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                DataInputStream das = new DataInputStream(inputStream);
                while (true) {
                    String message = das.readUTF();
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void run(String host, int port) {
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputManager inputManager = new InputManager(socket);
        Thread thread = new Thread(inputManager);
        thread.start();

        try {
            OutputStream out = socket.getOutputStream();
            DataOutputStream das = new DataOutputStream(out);
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String message = scanner.next();

                das.writeUTF(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
