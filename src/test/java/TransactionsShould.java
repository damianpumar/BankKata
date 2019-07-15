import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionsShould {
    private Transactions transactions;

    @Before
    public void setup() {
        this.transactions = new Transactions();
    }

    @Test
    public void save_transaction() {
        Transaction transaction = new Transaction(100, new Date());

        this.transactions.add(transaction);

        ArrayList<Transaction> allTransactions = this.transactions.getAll();

        for (Transaction storedTransaction : allTransactions)
            assertThat(storedTransaction).isSameAs(transaction);
    }
}