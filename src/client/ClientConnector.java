package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import helpers.Config;
import helpers.Request;
import helpers.Response;

public class ClientConnector {
    public static Response connectToServer(Request request) {
        try {
            Socket socket = new Socket(Config.host, Config.serverPortNo);
            ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
    
            toServer.writeObject(request);
            Response response = (Response) fromServer.readObject();
            socket.close();
            return response;
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new Response(Config.ERROR);
    }
}
