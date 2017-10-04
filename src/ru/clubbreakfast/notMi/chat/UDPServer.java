package ru.clubbreakfast.notMi.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;

import static ru.clubbreakfast.notMi.chat.ServerConsts.HOST;


public class UDPServer implements Server {

    private class Room implements Runnable {

        private Set<Integer> clients = new HashSet<>();
        private int port;

        public Room(int port) {
            this.port = port;
        }

        public void sendToClients(String message, int senderPort) throws IOException {

            DatagramSocket ds = new DatagramSocket();
            InetAddress ip = InetAddress.getByName(HOST);

            for (int clientPort : clients) {

                if (senderPort == clientPort) {
                    continue;
                }

                DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), ip, clientPort);
                ds.send(packet);

            }

            ds.close();

        }

        @Override
        public void run() {

            DatagramSocket ds = null;

            try {

                ds = new DatagramSocket(port);

                byte[] packetMas = new byte[1024];
                DatagramPacket packet = new DatagramPacket(packetMas, 1024);

                while (true) {

                    ds.receive(packet);
                    String message = new String(packet.getData(), 0, packet.getLength());

                    int senderPort = packet.getPort();

                    if (!clients.contains(senderPort)) {
                        System.out.println(senderPort);
                        clients.add(senderPort);
                        continue;
                    }

                    sendToClients(message, senderPort);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void addRoom(int port) {

        Room room = new Room(port);

        Thread thread = new Thread(room);
        thread.start();

    }

}
