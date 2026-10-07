import java.util.Scanner;

// BankAccount class - Data and business logic
class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful!");
            System.out.printf("Deposited Amount: %.2f%n", amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdrawal method
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } 
        else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } 
        else {
            balance -= amount;
            System.out.println("Withdrawal successful!");
            System.out.printf("Withdrawn Amount: %.2f%n", amount);
        }
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println();
        System.out.println("=================================");
        System.out.println("        ACCOUNT DETAILS");
        System.out.println("=================================");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.printf("Balance        : %.2f%n", balance);
        System.out.println("=================================");
    }
}


// ATM class - User Interface
public class DecodeLabs_Java_P3 {

    private BankAccount account;
    private Scanner sc;

    // Constructor
    public DecodeLabs_Java_P3() {

        sc = new Scanner(System.in);

        // Initial account details
        account = new BankAccount(
                "DL1001",
                "Student",
                10000.00
        );
    }

    // Display ATM menu
    public void displayMenu() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("         DECODE LABS ATM");
        System.out.println("=================================");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Account Details");
        System.out.println("5. Exit");
        System.out.println("=================================");
    }

    // Get valid number input
    private double getValidAmount() {

        while (!sc.hasNextDouble()) {

            System.out.println("Invalid input! Please enter a number.");
            sc.next();

        }

        double amount = sc.nextDouble();

        return amount;
    }

    // Run ATM
    public void runATM() {

        boolean running = true;

        System.out.println();
        System.out.println("=================================");
        System.out.println("      WELCOME TO DECODE LABS");
        System.out.println("          ATM SYSTEM");
        System.out.println("=================================");

        while (running) {

            displayMenu();

            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {

                System.out.println("Invalid choice! Please enter 1-5.");
                sc.next();

                System.out.print("Enter your choice: ");
            }

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    // Check balance
                    System.out.println();
                    System.out.println("---------------------------------");
                    System.out.println("Current Balance: "
                            + String.format("%.2f", account.getBalance()));
                    System.out.println("---------------------------------");
                    break;

                case 2:
                    // Deposit
                    System.out.print("Enter deposit amount: ");

                    double depositAmount = getValidAmount();

                    account.deposit(depositAmount);
                    break;

                case 3:
                    // Withdraw
                    System.out.print("Enter withdrawal amount: ");

                    double withdrawAmount = getValidAmount();

                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    // Account details
                    account.displayAccountDetails();
                    break;

                case 5:
                    // Exit
                    System.out.println();
                    System.out.println("=================================");
                    System.out.println(" Thank you for using Decode Labs");
                    System.out.println("        ATM System");
                    System.out.println("=================================");

                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1-5.");
            }
        }

        sc.close();
    }

    // Main method
    public static void main(String[] args) {

        DecodeLabs_Java_P3 atm = new DecodeLabs_Java_P3();

        atm.runATM();
    }
}