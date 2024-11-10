package Client;

import Exceptions.RemoteException;
import Interfaces.IRemoteGreeter;
import Server.Marshaller;

import java.io.IOException;

public class ClientProxy implements IRemoteGreeter {

    ClientRequestor requestor;

    public ClientProxy(ClientRequestor requestor) {
        this.requestor = requestor;
    }
    @Override
    public String hello(String name) throws RemoteException {
        return requestor.requestGreeting("hello", name);
    }
    @Override
    public String goodbye(String name) throws RemoteException {
        return requestor.requestGreeting("goodbye", name);
    }

    public String someUnsupportedMethod(String name) throws RemoteException {
        return requestor.requestGreeting("unsupported", name);
    }

}
