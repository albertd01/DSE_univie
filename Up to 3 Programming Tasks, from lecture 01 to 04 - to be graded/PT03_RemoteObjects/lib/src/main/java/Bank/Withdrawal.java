package Bank;

public class Withdrawal implements ITransaction, Runnable{
    private Account account;
    private double amount;

    public Withdrawal(double amount, Account acc) {
        this.amount = amount;
        this.account= acc;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public void carryOut() {
        account.withdraw(amount);
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
