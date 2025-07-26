package atm;

public class ATMOperations {
    private Account account;

    public ATMOperations(Account account) {
        this.account = account;
    }

    public boolean authenticate(int enteredPin) {
        return account.getPin() == enteredPin;
    }

    public double checkBalance() {
        return account.getBalance();
    }

    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        account.getMiniStatement().add("Deposited: ₹" + amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            account.getMiniStatement().add("Withdrawn: ₹" + amount);
            return true;
        } else {
            return false;
        }
    }

    public void printMiniStatement() {
        System.out.println("📄 Mini Statement:");
        if (account.getMiniStatement().isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String line : account.getMiniStatement()) {
                System.out.println(line);
            }
        }
    }
}
