package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IBankingServer extends Remote{
    public void transferMoney(String from, String to, double amount) throws RemoteException;
    public double audit() throws RemoteException;

    public List<String> getAccounts() throws RemoteException;
}
