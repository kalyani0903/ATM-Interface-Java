package atm;

import java.util.*;

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: User inputs account details
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();

        System.out.print("Set your 4-digit PIN: ");
        int pin = sc.nextInt();

        System.out.print("Enter Initial Balance: ₹");
        double balance = sc.nextDouble();
        sc.nextLine(); // Clear buffer

        // Step 2: Create account and ATM operation instance
        Account account = new Account(accNum, pin, balance);
        ATMOperations atm = new ATMOperations(account);

        // Step 3: PIN Authentication
        System.out.print("\nEnter your PIN to login: ");
        int enteredPin = sc.nextInt();

        if (!atm.authenticate(enteredPin)) {
            System.out.println("❌ Incorrect PIN. Exiting...");
            return;
        }

        // Step 4: Menu Loop
        while (true) {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("💰 Current Balance: ₹" + atm.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double deposit = sc.nextDouble();
                    atm.deposit(deposit);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawal = sc.nextDouble();
                    if (atm.withdraw(withdrawal)) {
                        System.out.println("✅ Withdrawal successful.");
                    } else {
                        System.out.println("❌ Insufficient balance.");
                    }
                    break;
                case 4:
                    atm.printMiniStatement();
                    break;
                case 5:
                    System.out.println("👋 Thank you for using the ATM!");
                    sc.close();
                    return;
                default:
                    System.out.println("⚠️ Invalid option. Try again.");
            }
        }
    }
}
