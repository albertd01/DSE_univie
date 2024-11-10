package Client;

import Server.IBankingServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.List;

public class RMIClient implements IBankingServer{
    IBankingServer bankingServer;
    public RMIClient(){
        try {
            bankingServer = (IBankingServer) Naming.lookup("rmi://localhost:" + Registry.REGISTRY_PORT + "/BankingServer");
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void transferMoney(String from, String to, double amount) throws RemoteException {
        bankingServer.transferMoney(from, to, amount);
    }

    @Override
    public double audit() throws RemoteException {
        return bankingServer.audit();
    }

    @Override
    public List<String> getAccounts() throws RemoteException {
        return bankingServer.getAccounts();
    }
}
