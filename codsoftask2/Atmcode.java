package codsoftask2;

import java.util.Scanner;

class tamilnadubank {
    private double balance;

    public tamilnadubank(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        	balance += amount;
      
        System.out.println("Deposit successful. New balance: " + balance);
   
        }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
            return true;
        }
    }
}

class ATM {
    private tamilnadubank userAccount;

    public ATM(tamilnadubank userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
    	System.out.println("welcome to Bank of TamilNadu..! ");
        System.out.println("1. Withdrawal amount");
        System.out.println("2. Deposit amount");
        System.out.println("3. Check Balance");
        System.out.println("0. Exit");
    }

    public void handleOption(int option, Scanner scanner) {
        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                if (withdrawAmount > 0) {
                    userAccount.withdraw(withdrawAmount);
                } else {
                    System.out.println("Invalid balance. Please enter a sufficient amount");
                }
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                if (depositAmount > 0) {
                    userAccount.deposit(depositAmount);
                } else {
                	
                    System.out.println("Daily limit is crossed So try again later");
                }
                break;
            case 3:
                System.out.println("Current balance: " + userAccount.getBalance());
                break;
            case 0:
                System.out.println("Exiting. Thank you for using Bank of Tamilnadu!");
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
}

public class Atmcode
{
    public static void main(String[] args) {
        
        tamilnadubank userAccount = new tamilnadubank(10000);

        // Create an ATM connected to the user's bank account
        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            // Display ATM menu
            atm.displayMenu();

            // Get user input
            System.out.print("Enter your choice: ");
            option= scanner.nextInt();
         

            
            atm.handleOption(option, scanner);

        } while (option != 0);

        scanner.close();
    }
}


