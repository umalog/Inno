package ru.clubbreakfast.at_the_lecture.oct2.sockets.sckts.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class DatagramClient {
    public static void main(String[] args) throws IOException{
        DatagramSocket ds = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        String message = scanner.next();

        InetAddress ip = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), ip, 4444); //Потр тут привязак к ПАКЕТУ, а не сокету как в TCP
        ds.send(packet);
        ds.close();
    }

}
