import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Menu extends Accounts {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(123456, 123);
                data.put(212212, 212);

                System.out.println("Welcome to the Virtual ATM Project");
                System.out.print("Enter your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter your PIN Number: ");
                setPinNumber(menuInput.nextInt());

                for (Entry<Integer, Integer> entry : data.entrySet()) {
                    if (entry.getKey().equals(getCustomerNumber()) && entry.getValue().equals(getPinNumber())) {
                        getAccountType();
                        return;
                    }
                }

                System.err.println("\nWrong Customer Number or PIN.\n");

            } catch (Exception e) {
                System.err.println("\nInvalid input. Please enter only numbers.\n");
                menuInput.nextLine(); // clear the invalid input
            }
        } while (x == 1);
    }

    // Displays the account type menu
    public void getAccountType() {
        System.out.println("\nSelect the Account you want to access");
        System.out.println("Type 1: Checking Account");
        System.out.println("Type 2: Saving Account");
        System.out.println("Type 3: Exit");
        System.out.print("Choice: ");

        try {
            int selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    getChecking();
                    break;
                case 2:
                    getSaving();
                    break;
                case 3:
                    System.out.println("\nThank you for using this Virtual ATM. See you soon!");
                    break;
                default:
                    System.err.println("\nInvalid Choice\n");
                    getAccountType();
            }
        } catch (Exception e) {
            System.err.println("\nInvalid input. Please enter a number.\n");
            menuInput.nextLine(); // clear buffer
            getAccountType();
        }
    }

    // Display Checking Account Menu
    public void getChecking() {
        System.out.println("\nChecking Account");
        System.out.println("Type 1: View Balance");
        System.out.println("Type 2: Withdraw Funds");
        System.out.println("Type 3: Deposit Funds");
        System.out.println("Type 4: Back to Account Type Menu");
        System.out.print("Choice: ");

        try {
            int selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("\nChecking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                    getChecking();
                    break;
                case 2:
                    getCheckingWithdrawalInput();
                    getChecking();
                    break;
                case 3:
                    getCheckingDepositInput();
                    getChecking();
                    break;
                case 4:
                    getAccountType();
                    break;
                default:
                    System.err.println("\nInvalid Choice\n");
                    getChecking();
            }
        } catch (Exception e) {
            System.err.println("\nInvalid input. Please enter a number.\n");
            menuInput.nextLine();
            getChecking();
        }
    }

    // Display Saving Account Menu
    public void getSaving() {
        System.out.println("\nSaving Account");
        System.out.println("Type 1: View Balance");
        System.out.println("Type 2: Withdraw Funds");
        System.out.println("Type 3: Deposit Funds");
        System.out.println("Type 4: Back to Account Type Menu");
        System.out.print("Choice: ");

        try {
            int selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("\nSaving Account Balance: " + moneyFormat.format(getSavingBalance()));
                    getSaving();
                    break;
                case 2:
                    getSavingWithdrawalInput();
                    getSaving();
                    break;
                case 3:
                    getSavingDepositInput();
                    getSaving();
                    break;
                case 4:
                    getAccountType();
                    break;
                default:
                    System.out.println("\nInvalid Choice\n");
                    getSaving();
            }
        } catch (Exception e) {
            System.err.println("\nInvalid input. Please enter a number.\n");
            menuInput.nextLine();
            getSaving();
        }
    }
}








