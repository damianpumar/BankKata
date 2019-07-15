public class Account implements AccountService {
    private Transactions transactions;
    private IClockMachine clockMachine;

    public Account(Transactions transactions, IClockMachine clockMachine) {
        this.transactions = transactions;
        this.clockMachine = clockMachine;
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
        throw new UnsupportedOperationException();
    }
}
