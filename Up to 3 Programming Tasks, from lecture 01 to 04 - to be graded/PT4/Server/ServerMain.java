package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
public class ServerMain {
    public static void main(String[] args) {
        int port = 8080; // Define the port on which the server will listen
        try {
            ServerRequestHandler serverRequestHandler = new ServerRequestHandler(port);
            System.out.println("Server is running on port " + port);

            Thread serverThread = new Thread(serverRequestHandler);
            serverThread.start();
        } catch (IOException e) {
            System.err.println("Error starting the server: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
