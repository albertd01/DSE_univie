package Bank;

public class Deposition implements ITransaction, Runnable{
    private Account account;
    private double amount;

    public Deposition(double amount, Account acc) {
        this.amount = amount;
        this.account= acc;
    }
    @Override
    public void carryOut() {
        account.deposit(amount);
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
