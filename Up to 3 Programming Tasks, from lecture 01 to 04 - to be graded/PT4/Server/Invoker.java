package Server;

import Exceptions.RemoteException;
import Interfaces.IRemoteGreeter;

public class Invoker {
    private byte[] request;

    public Invoker(byte[] request){
        this.request = request;
    }

    private String unmarshal(){
        return Marshaller.unmarshal(this.request);
    }

    public byte[] invokeMethod(IRemoteGreeter greeter) throws RemoteException {
        String result = "Unknown Error detected";
        String request = unmarshal();
        System.out.println(request);
        String[] parts = request.split(":");
        String method = parts[0];
        String argument = parts[1];

        switch (method) {
            case "hello":
                result = greeter.hello(argument) +":OK";
                break;
            case "goodbye":
                result = greeter.goodbye(argument) + ":OK";
                break;
            default:
                result ="Method not supported:ERROR";
        }
        return marshall(result);
    }
    private byte[] marshall(String response){
        return Marshaller.marshal(response);
    }

}
