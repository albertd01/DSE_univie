package Server;

import Exceptions.RemoteException;
import Interfaces.IRemoteGreeter;

public class EnglishRemoteGreeter implements IRemoteGreeter {

    @Override
    public String hello(String name) throws RemoteException {
        return "Hello, " + name;
    }

    @Override
    public String goodbye(String name) throws RemoteException {
        return name + ", goodbye";
    }
}
