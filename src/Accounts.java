import java.text.DecimalFormat;
import java.util.Scanner;

public class Accounts {
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance;
    private double savingBalance;

    // Setters
    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    // Getters
    public int getCustomerNumber() {
        return customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    // Withdraw from checking account
    public double calcCheckingWithdrawal(double amount) {
        checkingBalance -= amount;
        return checkingBalance;
    }

    // Withdraw from saving account
    public double calcSavingWithdrawal(double amount) {
        savingBalance -= amount;
        return savingBalance;
    }

    // Deposit into checking account
    public double calcCheckingDeposit(double amount) {
        checkingBalance += amount;
        return checkingBalance;
    }

    // Deposit into saving account
    public double calcSavingDeposit(double amount) {
        savingBalance += amount;
        return savingBalance;
    }

    // Input for checking withdrawal
    public void getCheckingWithdrawalInput() {
        System.out.println("\nChecking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Enter amount to withdraw from Checking Account: ");
        double amount = input.nextDouble();

        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdrawal(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.err.println("Insufficient funds. Balance cannot be negative.\n");
        }
    }

    // Input for saving withdrawal
    public void getSavingWithdrawalInput() {
        System.out.println("\nSaving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Enter amount to withdraw from Saving Account: ");
        double amount = input.nextDouble();

        if ((savingBalance - amount) >= 0) {
            calcSavingWithdrawal(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.err.println("Insufficient funds. Balance cannot be negative.\n");
        }
    }

    // Input for checking deposit
    public void getCheckingDepositInput() {
        System.out.println("\nChecking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Enter amount to deposit into Checking Account: ");
        double amount = input.nextDouble();

        calcCheckingDeposit(amount);
        System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
    }

    // Input for saving deposit
    public void getSavingDepositInput() {
        System.out.println("\nSaving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Enter amount to deposit into Saving Account: ");
        double amount = input.nextDouble();

        calcSavingDeposit(amount);
        System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
    }
}



















































