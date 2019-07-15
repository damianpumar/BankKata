import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {
    private Date SYSTEM_DATE = new Date(2012, 01, 10);
    private ArrayList<Transaction> ALL_Transactions = new ArrayList();

    private Account account;

    @Mock
    Transactions transactions;

    @Mock
    IClockMachine clockMachine;

    @Mock
    private StatementPrinter statementPrinter;

    @Before
    public void setup() {
        this.account = new Account(this.transactions, this.clockMachine, this.statementPrinter);

        when(this.clockMachine.date()).thenReturn(SYSTEM_DATE);
    }

    @Test
    public void store_a_deposit_transaction() {
        Transaction transaction = new Transaction(1000, SYSTEM_DATE);

        this.account.deposit(1000);

        verify(this.transactions, times(1)).add(transaction);
    }

    @Test
    public void store_a_withdrawal_transaction() {
        Transaction transaction = new Transaction(-100, SYSTEM_DATE);

        this.account.withdraw(100);

        verify(this.transactions, times(1)).add(transaction);
    }

    @Test
    public void print_statement_contains_all_transactions() {
        when(this.transactions.getAll()).thenReturn(ALL_Transactions);

        this.account.printStatement();

        verify(this.statementPrinter, times(1)).print(ALL_Transactions);
    }
}
