package Server;

import java.util.List;

import Bank.Bank;
import jakarta.jws.Oneway;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Endpoint;
import Server.soap.*;
@WebService(name = "BankingService", targetNamespace = "server.soap")
@XmlSeeAlso({

    ObjectFactory.class

})
public class SOAPServer implements BankingServicePortType{
	
	public SOAPServer() {
		String addr = "http://localhost:8002/bankingservice";
		Endpoint.publish(addr, this);
	}

	@Override
	@WebMethod(action = "TransferMoney")
	@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
	@Oneway
	public void transferMoney(
	        @WebParam(name = "transferMoneyRequest", targetNamespace = "Server.soap", partName = "parameters")
	        TransferMoneyRequest parameters) {
		Bank.BANK_INSTANCE.transfer(parameters.getFrom(), parameters.getTo(), parameters.getAmount());
	}

	@Override
	@WebMethod(action = "Audit")
	@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "auditResponse", targetNamespace = "Server.soap", partName = "parameters")
	public AuditResponse audit(
	        @WebParam(name = "auditRequest", targetNamespace = "Server.soap", partName = "parameters")
	        AuditRequest parameters) {
		double res = Bank.BANK_INSTANCE.audit();
		AuditResponse response = new AuditResponse();
		response.setAmount(res);
		return response;
	}

	@Override
	@WebMethod(action = "GetAccounts")
	@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "getAccountsResponse", targetNamespace = "Server.soap", partName = "parameters")
	public GetAccountsResponse getAccounts(
	        @WebParam(name = "getAccountsRequest", targetNamespace = "Server.soap", partName = "parameters")
	        GetAccountsRequest parameters) {
		// TODO Auto-generated method stub
		List<String> accounts = Bank.BANK_INSTANCE.getAccounts();
		GetAccountsResponse res = new GetAccountsResponse();
		for(String acc : accounts) {
			res.getAccounts().add(acc);
		}
		return res;
	}
	
}
