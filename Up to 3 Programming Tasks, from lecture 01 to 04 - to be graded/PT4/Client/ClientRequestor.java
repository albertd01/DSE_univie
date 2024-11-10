package Client;

import Exceptions.RemoteException;
import Server.Marshaller;

import java.io.IOException;

public class ClientRequestor{
    private ClientRequestHandler handler;

    public ClientRequestor(ClientRequestHandler handler) {
        this.handler = handler;
    }
    private byte[] marshall(String request){
        return Marshaller.marshal(request);
    }
    private String unmarshall(byte[] response){
        return Marshaller.unmarshal(response);
    }
    public String requestGreeting(String method, String name) throws RemoteException{
        byte[] marshalledRequest = marshall(method+":"+name);
        handler.send(marshalledRequest);
        byte[] marshalledResponse = handler.receive();
        String response = unmarshall(marshalledResponse);
        response = checkResponse(response);
        return response;
    }

    private String checkResponse(String response) throws RemoteException {
        String[] parts = response.split(":");
        if(parts[1].equals("ERROR")){
            throw new RemoteException(parts[1]+ ": " + parts[0]);
        }
        return parts[0];
    }
}
