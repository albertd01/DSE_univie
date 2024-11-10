package Client;

import Exceptions.RemoteException;

import java.io.IOException;

public class ClientMain {
    public static void main(String[] args) {
        try (ClientRequestHandler requestHandler = new ClientRequestHandler("localhost", 8080)) {
            ClientRequestor requestor = new ClientRequestor(requestHandler);
            ClientProxy proxy = new ClientProxy(requestor);
            try{
                System.out.println(proxy.hello("DSE"));
                System.out.println(proxy.goodbye("DSE"));
                System.out.println(proxy.someUnsupportedMethod("DSE"));
            }catch(RemoteException e){
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
