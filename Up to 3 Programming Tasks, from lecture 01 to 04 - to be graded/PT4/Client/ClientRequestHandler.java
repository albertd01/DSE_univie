package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class ClientRequestHandler implements AutoCloseable{
    private Socket socket;
    private OutputStream out;
    private InputStream in;

    public ClientRequestHandler(String host, int port) throws IOException {
        socket = new Socket(host, port);
        out = socket.getOutputStream();
        in = socket.getInputStream();
    }

    public void send(byte[] data) {
        try{
            out.write(data);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public byte[] receive()  {

        byte[] buffer = new byte[1024];
        int bytesRead = 0;
        try{
            bytesRead = in.read(buffer);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return Arrays.copyOf(buffer, bytesRead);
    }

    @Override
    public void close() throws IOException {
        try {
            if (in != null) {
                in.close();
            }
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } finally {
                if (socket != null) {
                    socket.close();
                }
            }
        }
    }
}
