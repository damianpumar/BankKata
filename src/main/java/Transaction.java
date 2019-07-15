import java.util.Date;

public class Transaction {
    private final int amount;
    private final Date date;

    public Transaction(int amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    @Override
    public boolean equals(Object obj) {
        Transaction transaction = (Transaction) obj;

        return transaction.amount == this.amount &&
                transaction.date == this.date;
    }
}
