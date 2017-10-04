package ru.clubbreakfast.notMi.chat;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPClient implements Client {

    private volatile DatagramSocket socket;

    public UDPClient() {

        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    private class InputManager implements Runnable {

        private String serverHost;
        private int serverPort;

        public InputManager(String serverHost, int serverPort) {
            this.serverHost = serverHost;
            this.serverPort = serverPort;

        }

        @Override
        public void run() {

            try {

                InetAddress ip = InetAddress.getByName(serverHost);
                DatagramPacket packet = new DatagramPacket("".getBytes(), 0, ip, serverPort);

                socket.send(packet);

                byte[] packetMas = new byte[1024];
                packet = new DatagramPacket(packetMas, 1024);

                while (true) {
                    socket.receive(packet);
                    String message = new String(packet.getData(), 0, packet.getLength());
                    System.out.println(message);
                }

            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void run(String host, int port) {

        InputManager inputManager = new InputManager(host, port);
        Thread thread = new Thread(inputManager);
        thread.start();

        try {

            Scanner scanner = new Scanner(System.in);

            while (true) {

                String message = scanner.next();

                InetAddress ip = InetAddress.getByName(host);

                DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), ip, port);

                socket.send(packet);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
