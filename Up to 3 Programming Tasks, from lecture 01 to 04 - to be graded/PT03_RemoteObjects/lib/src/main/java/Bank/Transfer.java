package Bank;

public class Transfer implements ITransaction, Runnable{
    private Account sender;
    private Account recipient;
    private double amount;

    public Transfer(Account sender, Account recipient, double amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
    }

    @Override
    public void carryOut() {
        sender.withdraw(amount);
        recipient.deposit(amount);
    }

    @Override
    public void run() {
        carryOut();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
