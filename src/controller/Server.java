package controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

    int serverPort;
    private ServerSocket serverSocket;
    public Server(ServerSocket serverSocket, int serverPort) {
        this.serverPort=serverPort;
        this.serverSocket=serverSocket;
    }

    @Override
    public void run() {

        try {
            serverSocket = new ServerSocket(serverPort);
            ServerClient.log("[Sever] waiting for connections...");
            Socket socket = serverSocket.accept();

            ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            Object received = input.readObject();
            Datapackage message = (Datapackage) received;
            ServerClient.log("[Server] Message received: " +message);

            if(message.id.equalsIgnoreCase("PING")){

            }
            if(message.id.equalsIgnoreCase("BOARD")){

            }if(message.id.equalsIgnoreCase("CHAT")){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch ( ClassNotFoundException n){
            n.printStackTrace();
        }
    }


}
