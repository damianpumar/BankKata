import java.util.ArrayList;

public class Transactions {
    private final ArrayList<Transaction> transactions;

    public Transactions() {
        this.transactions = new ArrayList();
    }

    public void add(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public ArrayList<Transaction> getAll() {
        return this.transactions;
    }
}
