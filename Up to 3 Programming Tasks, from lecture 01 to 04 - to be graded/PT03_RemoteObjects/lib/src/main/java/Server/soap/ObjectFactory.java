
package Server.soap;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Server.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Server.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransferMoneyRequest }
     * 
     * @return
     *     the new instance of {@link TransferMoneyRequest }
     */
    public TransferMoneyRequest createTransferMoneyRequest() {
        return new TransferMoneyRequest();
    }

    /**
     * Create an instance of {@link AuditRequest }
     * 
     * @return
     *     the new instance of {@link AuditRequest }
     */
    public AuditRequest createAuditRequest() {
        return new AuditRequest();
    }

    /**
     * Create an instance of {@link AuditResponse }
     * 
     * @return
     *     the new instance of {@link AuditResponse }
     */
    public AuditResponse createAuditResponse() {
        return new AuditResponse();
    }

    /**
     * Create an instance of {@link GetAccountsRequest }
     * 
     * @return
     *     the new instance of {@link GetAccountsRequest }
     */
    public GetAccountsRequest createGetAccountsRequest() {
        return new GetAccountsRequest();
    }

    /**
     * Create an instance of {@link GetAccountsResponse }
     * 
     * @return
     *     the new instance of {@link GetAccountsResponse }
     */
    public GetAccountsResponse createGetAccountsResponse() {
        return new GetAccountsResponse();
    }

}
