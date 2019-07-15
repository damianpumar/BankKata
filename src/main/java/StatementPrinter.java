import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatementPrinter {
    private final String STATEMENT_HEADER = "Date || Amount || Balance";
    private final String STATEMENT_BODY_FORMAT = "\n{0} || {1} || {2}";
    private IConsole console;

    public StatementPrinter(IConsole console) {
        this.console = console;
    }

    public void print(ArrayList<Transaction> transactions) {
        this.console.print(this.createStatementLines(transactions));
    }

    private String createStatementLines(ArrayList<Transaction> transactions) {
        List<String> bodyTransactions = formatTransactions(transactions);

        return concatWithHeader(bodyTransactions);
    }

    private String concatWithHeader(List<String> bodyTransactions) {
        String outputStatement = STATEMENT_HEADER;

        for (String transaction : bodyTransactions) {
            outputStatement += transaction;
        }

        return outputStatement;
    }

    private List<String> formatTransactions(ArrayList<Transaction> transactions) {
        int balance = 0;

        List<String> statement = new ArrayList();

        for (Transaction transaction : transactions) {
            balance += transaction.amount();

            statement.add(formatTransaction(transaction, balance));
        }

        Collections.reverse(statement);
        return statement;
    }

    private String formatTransaction(Transaction transaction, int balance) {
        return MessageFormat.format(STATEMENT_BODY_FORMAT, this.formatDate(transaction), this.formatDecimal(transaction.amount()), this.formatDecimal(balance));
    }

    private String formatDate(Transaction transaction) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return simpleDateFormat.format(transaction.date());
    }

    private String formatDecimal(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#");
        return decimalFormat.format(amount);
    }
}
