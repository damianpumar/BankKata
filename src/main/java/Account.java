public class Account implements AccountService {
    private Transactions transactions;
    private IClockMachine clockMachine;
    private StatementPrinter statementPrinter;

    public Account(Transactions transactions, IClockMachine clockMachine, StatementPrinter statementPrinter) {
        this.transactions = transactions;
        this.clockMachine = clockMachine;
        this.statementPrinter = statementPrinter;
    }

    @Override
    public void deposit(int amount) {
        this.storeTransaction(amount);
    }

    @Override
    public void withdraw(int amount) {
        this.storeTransaction(-amount);
    }

    @Override
    public void printStatement() {
        this.statementPrinter.print(this.transactions.getAll());
    }

    private void storeTransaction(int amount) {
        this.transactions.add(new Transaction(amount, this.clockMachine.date()));
    }
}
