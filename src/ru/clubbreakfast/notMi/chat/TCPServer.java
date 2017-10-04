package ru.clubbreakfast.notMi.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class TCPServer implements Server {

    private class MessageRouter implements Runnable {

        private CopyOnWriteArrayList<Socket> sockets;
        private volatile Socket socket;

        public MessageRouter(CopyOnWriteArrayList<Socket> sockets, Socket socket) {
            this.sockets = sockets;
            this.socket = socket;
        }

        @Override
        //рассыльщик
        public void run() {
            try (InputStream inputStream = socket.getInputStream();
                 DataInputStream dis = new DataInputStream(inputStream)) {
                while (true) {
                    String message = dis.readUTF();
                    for (Socket otherSocket : sockets) {
                        if (socket == otherSocket) continue;

                        OutputStream out = otherSocket.getOutputStream();
                        DataOutputStream das = new DataOutputStream(out);
                        das.writeUTF(message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class Room implements Runnable {

        private int port;
        private CopyOnWriteArrayList<Socket> sockets = new CopyOnWriteArrayList<>();

        public Room(int port) {
            this.port = port;
        }

        @Override
        public void run() {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(port);
                while (true) {
                    Socket socket = serverSocket.accept();
                    sockets.add(socket);
                    MessageRouter messageRouter = new MessageRouter(sockets, socket);
                    Thread thread = new Thread(messageRouter);
                    thread.start();
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
