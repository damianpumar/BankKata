import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public void print_transactions_using_console() throws ParseException {
        ArrayList<Transaction> transactions = new ArrayList() {
            {
                add(new Transaction(1000, createDate("10/01/2012")));
                add(new Transaction(2000, createDate("13/01/2012")));
                add(new Transaction(-500, createDate("14/01/2012")));
            }
        };

        String outputExpected = "Date || Amount || Balance\n" +
                "14/01/2012 || -500 || 2500\n" +
                "13/01/2012 || 2000 || 3000\n" +
                "10/01/2012 || 1000 || 1000";

        this.statementPrinter.print(transactions);

        verify(this.console, times(1)).print(outputExpected);
    }

    private Date createDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return sdf.parse(date);
    }
}