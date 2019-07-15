import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterShould {

    private StatementPrinter statementPrinter;

    @Mock
    IConsole console;

    @Before
    public void setup() {
        this.statementPrinter = new StatementPrinter(this.console);
    }

    @Test
    public void print_transactions_using_console() {
        ArrayList<Transaction> transactions = new ArrayList() {
            {
                add(new Transaction(1000, new Date(2012, 10, 01)));
                add(new Transaction(2000, new Date(2012, 13, 01)));
                add(new Transaction(-500, new Date(2012, 14, 01)));
            }
        };

        String outputExpected = "Date       || Amount || Balance\n" +
                "14/01/2012 || -500   || 2500\n" +
                "13/01/2012 || 2000   || 3000\n" +
                "10/01/2012 || 1000   || 1000";

        this.statementPrinter.print(transactions);

        verify(this.console, times(1)).print(outputExpected);
    }
}