package controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClient {

    int serverPort;
    String hostname;
    private ServerSocket serverSocket;

    public ServerClient(String hostname, int port) {
        this.hostname = hostname;
        this.serverPort = port;
        startListening();
    }

    private void startListening() {
        Server server = new Server(serverSocket, serverPort);
        Thread serverThead = new Thread(server);
        serverThead.start();
        Client client = new Client();
        Thread clientThread = new Thread(client);
    }

    static void log(String output) {
        System.out.println(output);
    }


}
