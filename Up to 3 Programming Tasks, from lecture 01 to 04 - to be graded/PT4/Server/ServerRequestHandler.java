package Server;

import Exceptions.RemoteException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Arrays;

public class ServerRequestHandler implements Runnable {
    private ServerSocket serverSocket;
    public ServerRequestHandler(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void run() {
        while (true) {
            try (Socket clientSocket = serverSocket.accept();
                 InputStream in = clientSocket.getInputStream();
                 OutputStream out = clientSocket.getOutputStream()) {


                System.out.println("Connected to client: " + clientSocket);

                try {
                    while (!clientSocket.isClosed()) {
                        byte[] buffer = new byte[1024];
                        int bytesRead = in.read(buffer);
                        if (bytesRead == -1) {
                            break;
                        }
                        Invoker invoker = new Invoker(Arrays.copyOf(buffer, bytesRead));
                        out.write(invoker.invokeMethod(new EnglishRemoteGreeter()));
                    }
                } catch (SocketException e) {
                    System.out.println("Socket exception: " + e.getMessage());
                } catch (RemoteException e) {
                    System.out.println("Remote exception: " + e.getMessage());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}