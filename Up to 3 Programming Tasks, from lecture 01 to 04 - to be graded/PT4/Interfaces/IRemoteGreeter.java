package Interfaces;

import Exceptions.RemoteException;

import java.io.IOException;

public interface IRemoteGreeter {
    public String hello(String name) throws RemoteException;
    public String goodbye(String name) throws RemoteException;
}
