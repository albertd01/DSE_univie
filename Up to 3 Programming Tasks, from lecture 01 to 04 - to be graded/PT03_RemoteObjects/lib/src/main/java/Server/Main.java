package Server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException, MalformedURLException{
        RMIServer rmi = new RMIServer();
        System.out.println("RMI Server is online");
        SOAPServer soap = new SOAPServer();
        System.out.println("SOAP Server is online");
    }
}
