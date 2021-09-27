import java.util.Scanner;

public class BankAccount {
  private int balance;
  private int previousTransaction;
  private String customerName;
  private String customerId;

  public BankAccount(String cName, String cId) {
    customerName = cName;
    customerId = cId;
  }

  void deposit(int amount) {
    if(amount > 0) {
      balance += amount;
      previousTransaction = amount;
      System.out.println("You deposited " + amount);
      if(balance >= 0) {
        System.out.println("Your balance is now " + balance);
      } else {
        System.out.println("You are now overdrawn by " + Math.abs(balance));
      }
    } else {
      System.out.println("You must deposit 0 or less");
    }
  }
  
  void withdrawal(int amount) {
    if (amount > 0) {
      balance -= amount;
      previousTransaction = -amount;
      System.out.println("You withdrew " + amount);
      if(balance >= 0) {
        System.out.println("Your balance is now " + balance);
      } else {
        System.out.println("You are now overdrawn by " + Math.abs(balance));
      }
    } else {
      System.out.println("You must withdraw 0 or more");
    }
  }

  void getPreviousTransaction() {
    if(previousTransaction > 0) {
      System.out.println("Deposited: " + previousTransaction);
    } else if(previousTransaction < 0) {
      System.out.println("Withdrew: " + Math.abs(previousTransaction));
    } else {
      System.out.println("No transaction occured");
    }
  }

  void showMenu() {
    char option;
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome " + customerName);
    System.out.println("Your ID is " + customerId);
    System.out.println("\n");
    System.out.println("A - Check Balance");
    System.out.println("B - Deposit");
    System.out.println("C - Withdraw");
    System.out.println("D - Previous Transaction");
    System.out.println("E - Exit");

    do {
      System.out.println("=================");
      System.out.println("Enter an option");
      System.out.println("=================");
      option = Character.toUpperCase(scanner.next().charAt(0));

      if(option == 'A') {
        System.out.println("-----------------");
        System.out.println("Your balance is: " + balance);
        System.out.println("-----------------");
      } else if(option == 'B') {
        System.out.println("-----------------");
        System.out.println("Enter an amount to deposit");
        System.out.println("-----------------");
        int amount = scanner.nextInt();
        deposit(amount);
        System.out.println("\n");
      } else if(option == 'C') {
        System.out.println("-----------------");
        System.out.println("Enter an amount to withdraw");
        System.out.println("-----------------");
        int amount = scanner.nextInt();
        withdrawal(amount);
        System.out.println("\n");
      } else if(option == 'D') {
        System.out.println("-----------------");
        getPreviousTransaction();
        System.out.println("-----------------");
      } else if(option == 'E') {
        System.out.println("*****************");
      } else {
        System.out.println("Please enter a valid option");
      }
    }
    while(option != ('E'));

    System.out.println("Thank you for banking with us!  Goobye.");
  }
}
