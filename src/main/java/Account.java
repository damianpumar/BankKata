public class Account implements AccountService {
    private Transaction transaction;
    private IClockMachine clockMachine;

    public Account(Transaction transaction, IClockMachine clockMachine) {
        this.transaction = transaction;
        this.clockMachine = clockMachine;
    }

    @Override
    public void deposit(int amount) {
        this.transaction.add(amount, this.clockMachine.date());
    }
}
