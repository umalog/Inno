package ru.clubbreakfast.at_the_lecture.oct2.sockets.sckts.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(4444);

        byte[] packetMas = new byte[1024];
        DatagramPacket packet = new DatagramPacket(packetMas, 1024);

        ds.receive(packet);

        String message = new String(packet.getData(), 0, packet.getLength());
        System.out.println(message);

        ds.close();
    }
}
