package Bank;

import java.util.List;

public interface IBanking {
    public void transfer(String from, String to, double amount);
    public double audit();

    public List<String> getAccounts();
}
