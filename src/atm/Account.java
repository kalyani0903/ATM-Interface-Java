package atm;

import java.util.*;

public class Account {
    private String accountNumber;
    private int pin;
    private double balance;
    private List<String> miniStatement;

    public Account(String accountNumber, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.miniStatement = new ArrayList<>();
    }

    public String getAccountNumber() { return accountNumber; }
    public int getPin() { return pin; }
    public double getBalance() { return balance; }
    public List<String> getMiniStatement() { return miniStatement; }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
