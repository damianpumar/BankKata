import java.util.Date;

public class Transaction {
    private final int amount;
    private final Date date;

    public Transaction(int amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public int amount() {
        return this.amount;
    }

    public Date date() {
        return this.date;
    }

    @Override
    public boolean equals(Object obj) {
        Transaction transaction = (Transaction) obj;

        return transaction.amount == this.amount &&
                transaction.date == this.date;
    }
}
