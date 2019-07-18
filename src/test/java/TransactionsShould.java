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

    @Test
    public void transaction_is_equal_to_other_transaction_when_both_has_same_amount_and_date() {
        Date date = new Date();

        Transaction transactionOne = new Transaction(100, date);
        Transaction transactionTwo = new Transaction(100, date);

        assertThat(transactionOne.equals(transactionTwo)).isTrue();
    }

    @Test
    public void transaction_is_not_equal_to_other_transaction_when_both_has_different_amount() {
        Date date = new Date();

        Transaction transactionOne = new Transaction(100, date);
        Transaction transactionTwo = new Transaction(101, date);

        assertThat(transactionOne.equals(transactionTwo)).isFalse();
    }

    @Test
    public void transaction_is_not_equal_to_other_transaction_when_both_has_different_date() {
        Transaction transactionOne = new Transaction(100, new Date());
        Transaction transactionTwo = new Transaction(100, new Date());

        assertThat(transactionOne.equals(transactionTwo)).isFalse();
    }
}