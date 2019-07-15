import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {
    private Date SYSTEM_DATE = new Date(2012, 01, 10);

    private Account account;

    @Mock
    Transaction transaction;

    @Mock
    IClockMachine clockMachine;

    @Before
    public void setup() {
        this.account = new Account(this.transaction, this.clockMachine);

        when(this.clockMachine.date()).thenReturn(SYSTEM_DATE);
    }

    @Test
    public void store_a_deposit_transaction() {
        this.account.deposit(1000);

        verify(this.transaction, times(1)).add(1000, SYSTEM_DATE);
    }

    @Test
    public void store_a_withdrawal_transaction() {
        this.account.withdraw(-100);

        verify(this.transaction, times(1)).add(-100, SYSTEM_DATE);
    }
}
