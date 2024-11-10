package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import Bank.Bank;
public class RMIServer extends UnicastRemoteObject implements IBankingServer{
    public RMIServer() throws RemoteException, MalformedURLException {
        LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        Naming.rebind("rmi://localhost:" + Registry.REGISTRY_PORT  + "/BankingServer", this);
    }
    @Override
    public void transferMoney(String from, String to, double amount) throws RemoteException {
        Bank.BANK_INSTANCE.transfer(from, to, amount);
    }

    @Override
    public double audit() throws RemoteException {
        return Bank.BANK_INSTANCE.audit();
    }

    @Override
    public List<String> getAccounts() {
        return Bank.BANK_INSTANCE.getAccounts();
    }
}
