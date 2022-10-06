package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import helpers.Config;

public class ServerConnector {
    private static int clientCount = 0;
    // private static ExecutorService pool = Executors.newFixedThreadPool(5);
    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(Config.serverPortNo)) {
            System.out.println("Server up and running on port " + Config.serverPortNo);
            
            DatabaseConnector databaseConnector = new DatabaseConnector();
            databaseConnector.setupDatabaseConnection();
            System.out.println("Waiting for client requests");
            
            while(true) {
                Socket socket = serverSocket.accept();
                new Thread(new ClientHandler(socket, databaseConnector, ++clientCount)).start();
            }
        }
    }
}