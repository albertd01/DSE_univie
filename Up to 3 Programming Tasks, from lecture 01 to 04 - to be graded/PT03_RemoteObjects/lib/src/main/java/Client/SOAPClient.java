package Client;

import java.rmi.RemoteException;
import java.util.List;

import Server.IBankingServer;
import Server.soap.AuditRequest;
import Server.soap.AuditResponse;
import Server.soap.BankingService;
import Server.soap.BankingServicePortType;
import Server.soap.GetAccountsRequest;
import Server.soap.GetAccountsResponse;
import Server.soap.TransferMoneyRequest;

public class SOAPClient implements IBankingServer{
	private BankingServicePortType service;
	
	public SOAPClient() {
		BankingService serv =new BankingService();
		this.service = serv.getBankingServicePort(); 
	}

	@Override
	public void transferMoney(String from, String to, double amount) throws RemoteException {
		TransferMoneyRequest request = new TransferMoneyRequest();
		request.setFrom(from);
		request.setTo(to);
		request.setAmount(amount);
		this.service.transferMoney(request);
	}

	@Override
	public double audit() throws RemoteException {
		AuditResponse response = this.service.audit(new AuditRequest());
		return response.getAmount();
	}

	@Override
	public List<String> getAccounts() throws RemoteException {
		GetAccountsRequest request = new GetAccountsRequest();
		GetAccountsResponse response = this.service.getAccounts(request);
		return response.getAccounts();
	}

}
