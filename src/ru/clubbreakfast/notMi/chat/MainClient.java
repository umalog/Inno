package ru.clubbreakfast.notMi.chat;

public class MainClient {

    public static void main(String[] args) {

        Client client = new UDPClient();
        client.run(ServerConsts.HOST, ServerConsts.PORT+1);

    }

}
