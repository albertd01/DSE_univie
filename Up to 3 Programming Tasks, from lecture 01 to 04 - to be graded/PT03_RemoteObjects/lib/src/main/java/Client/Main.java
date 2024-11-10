package Client;


import Server.IBankingServer;

import java.util.Random;

import java.rmi.RemoteException;

public class Main {
	private static final Random random = new Random();
    public static void main (String[] args) throws RemoteException {
        RMIClient rmi = new RMIClient();
        simulateWallStreet(rmi);
        System.out.println("Done simulating RMI");
        SOAPClient soap = new SOAPClient();
        simulateWallStreet(soap);
        System.out.println("Done simulating SOAP");
    }

    private static void simulateWallStreet(IBankingServer remoteServer) throws RemoteException {
        System.out.println(remoteServer.audit());
        for(int i = 0; i < 100; ++i){
        	int index = random.nextInt(0,8);
        	double amount = random.nextDouble(1,200);
            String sender = remoteServer.getAccounts().get(index);
            String recipient = remoteServer.getAccounts().get(index+1);
            remoteServer.transferMoney(sender, recipient, amount);
            if(i%20 == 0){
                System.out.println(remoteServer.audit());
            }
        }
        System.out.println(remoteServer.audit());
        try{
            Thread.sleep(5000);
            System.out.println(remoteServer.audit());
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(remoteServer.audit());
    }

}
