package Bank;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Account{
    private double balance;
    private String IBAN;
    private Queue<ITransaction> pendingTransactions = new LinkedBlockingQueue<>();

    public Account(double initialBalance, String IBAN) {
        this.balance = initialBalance;
        this.IBAN = IBAN;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
    public String getIBAN(){
        return IBAN;
    }
}
