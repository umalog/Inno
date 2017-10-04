package ru.clubbreakfast.notMi.chat;

public class MainServer {

    public static void main(String[] args) {

        Server server = new UDPServer();
        server.addRoom(ServerConsts.PORT);
        server.addRoom(ServerConsts.PORT+1);
        server.addRoom(ServerConsts.PORT+2);

    }

}
