package Bank;

import java.util.*;

public enum Bank implements IBanking{
    BANK_INSTANCE;
    private Map<String,Account> accounts;
    private TransactionManager transactionManagement = new TransactionManager();

    Bank() {
        this.accounts = new HashMap<String, Account>();
        accounts.put("AT48 0000 0000 0000 0000", new Account(10000, "AT48 0000 0000 0000 0000"));
        accounts.put("AT48 1000 0000 0000 0000", new Account(10000, "AT48 1000 0000 0000 0000"));
        accounts.put("AT48 2000 0000 0000 0000", new Account(10000, "AT48 2000 0000 0000 0000"));
        accounts.put("AT48 3000 0000 0000 0000", new Account(10000, "AT48 3000 0000 0000 0000"));
        accounts.put("AT48 4000 0000 0000 0000", new Account(10000, "AT48 4000 0000 0000 0000"));
        accounts.put("AT48 5000 0000 0000 0000", new Account(10000, "AT48 5000 0000 0000 0000"));
        accounts.put("AT48 6000 0000 0000 0000", new Account(10000, "AT48 6000 0000 0000 0000"));
        accounts.put("AT48 7000 0000 0000 0000", new Account(10000, "AT48 7000 0000 0000 0000"));
        accounts.put("AT48 8000 0000 0000 0000", new Account(10000, "AT48 8000 0000 0000 0000"));
        accounts.put("AT48 9000 0000 0000 0000", new Account(10000, "AT48 9000 0000 0000 0000"));
    }

    @Override
    public void transfer(String from, String to, double amount) {
        Account sender = accounts.get(from);
        Withdrawal withdrawal = new Withdrawal(amount, sender);
        transactionManagement.addPendingTransaction(withdrawal);
        Account recipient = accounts.get(to);
        Deposition deposition = new Deposition(amount, recipient);
        transactionManagement.addPendingTransaction(deposition);
    }
    @Override
    public double audit() {
        return accounts.values().stream().mapToDouble(Account::getBalance).sum();
    }

    public List<String> getAccounts() {
        return new ArrayList<String>(accounts.keySet());
    }

}