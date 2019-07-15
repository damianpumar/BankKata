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
        this.transactions.add(amount, this.clockMachine.date());
    }

    @Override
    public void withdraw(int amount) {
        this.transactions.add(amount, this.clockMachine.date());
    }

    @Override
    public void printStatement() {
        this.statementPrinter.print(this.transactions.getAll());
    }
}
