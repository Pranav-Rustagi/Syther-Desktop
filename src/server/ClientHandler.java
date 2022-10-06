package server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import helpers.Config;
import helpers.Request;
import helpers.Response;

public class ClientHandler implements Runnable {

    private Socket socket;
    private DatabaseConnector databaseConnector;
    private ObjectOutputStream toClient;
    private ObjectInputStream fromClient;
    private String threadName;

    public ClientHandler(Socket socket, DatabaseConnector databaseConnector, int clientId) throws IOException {
        threadName = "Thead " + clientId;
        this.socket = socket;
        this.databaseConnector = databaseConnector;
        toClient = new ObjectOutputStream(this.socket.getOutputStream());
        fromClient = new ObjectInputStream(this.socket.getInputStream());
    }

    @Override
    public void run() {
        try {
            while(true) {
                Request request = (Request) fromClient.readObject();
                String requestType = request.getType();

                if(requestType.equals(Config.CONNECTION_REQUEST)) {
                    System.out.println(threadName + " : A client is trying to connect.\nConnected to Client\n");
                    toClient.writeObject(new Response(Config.CONNECTED));
                }
                if(requestType.equals(Config.SIGNUP_REQUEST)) {
                    System.out.println(threadName + " : A client is trying to sign up...");

                    String respoString = databaseConnector.registerUser(request.getUser());
                    toClient.writeObject(new Response(respoString));

                    if(respoString.equals(Config.SIGNED_UP))
                        System.out.println(threadName + " : Client account created successfully\n");
                    else if(respoString.equals(Config.ALREADY_EXISTS))
                        System.out.println(threadName + " : Client account already exists with provided email\n");
                    else if(respoString.equals(Config.ERROR))
                        System.out.println(threadName + " : Client account could not be created\n");
                }
                else if(requestType.equals(Config.LOGIN_REQUEST)) {
                    System.out.println(threadName + " : A client is trying to sign in...\nCredentials to be Checked...");

                    String respoString = databaseConnector.verifyCredentials(request.getUser());
                    toClient.writeObject(new Response(respoString));
                    
                    if(respoString.equals(Config.LOGGED_IN)) {
                        System.out.println(threadName + " : Client account credentials verified\n");
                    }
                    else if(respoString.equals(Config.CREDENTIALS_NOT_MATCH)) {
                        System.out.println(threadName + " : Client credentials are invalid\n");
                    }
                }
            }
        }
        catch (EOFException e) {
            // e.printStackTrace();
        }
        catch(IOException e) {
            // e.printStackTrace();
            try {
                toClient.writeObject(new Response(Config.ERROR));
            } 
            catch (IOException e1) {
                // e1.printStackTrace();
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            try {
                toClient.writeObject(new Response(Config.ERROR));
            } 
            catch (IOException e1) {
                // e1.printStackTrace();
            }
        }
        finally {
            try {
                toClient.close();
                fromClient.close();
            } 
            catch (IOException e) {
                // e.printStackTrace();
            }
            System.out.println("Waiting for client requests");
        }
    }
    
}
