import java.util.ArrayList;
import java.util.Scanner;

public class MajorFeatures {

  

    public static void allInOneProcess(int processNumber, Customer c, Scanner input) throws MyExceptions {
        if (processNumber == 1) {
            try {
                withdrawCash(c, input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (processNumber == 2) {
            changePin(c, input);
        } else if (processNumber == 3) {
            transactionHistory(c);
        } else {
            System.out.println("Wrong input");
        }
    }

    public static void changePin(Customer c, Scanner input) {
        System.out.println("Enter your current pin");
        int currectPin = input.nextInt();

        if(c.customerPin == currectPin){
            System.out.println("Enter new pin");
            int newPin = input.nextInt();
            c.customerPin = newPin;
            System.out.println(c.customerName + " " + c.customerPin);
        }else{
            System.out.println("Pin is wrong try again, otherwise visit to bank");
        }

    }

    public static void createCustomer(String permission, Scanner input, ArrayList<Customer> customerList) {

        if (permission.equals("yes")) {
            System.out.println("Enter you name");
            String name = input.next();

            System.out.println("Enter you 3 digit pin");
            int pin = input.nextInt();

            if (pin >= 100 && pin <= 999) {

                Customer newCustomer = new Customer(name, pin);
                customerList.add(newCustomer);


            } else {
                System.out.println("Pin is not valid, pin should on contain 3 digit number");
            }
        } else if (permission.equals("no")) {
            System.out.println("Thanks of visiting!");
        }
    }

    public static void withdrawCash(Customer c, Scanner input) throws MyExceptions {
        System.out.println("Your balance is " + c.customerBalance + "\nEnter amount to withdraw ");
        int amount = input.nextInt();
        if (amount > c.customerBalance) {
            throw new MyExceptions("you balance should be greather than amount you want to withdraw");
        } else {
            System.out
                    .println(amount + " is withdraw successfully , currect balance is " + (c.customerBalance - amount));
            c.customerBalance -= amount;
            c.customerTransactions.add(amount);
        }
    }

    public static void transactionHistory(Customer c) {
        for(int transaction : c.customerTransactions){
            System.out.println(transaction);
        }
    }


    public static void afterVarificationProcess(Customer c, boolean pinVarification, Scanner input)
            throws MyExceptions {
        if (pinVarification) {
            System.out.println("Name is :- " + c.customerName + " " + "Account Number is :- " + c.customerAccountNumber);
            System.out.println("What do you want to do :-  \n1.withdraw cash \n2.change pin \n3.transaction history");
            System.out.println("choose a number");
            int process = input.nextInt();
            MajorFeatures.allInOneProcess(process, c, input);
        } else {
            System.out.println("wrong pin");
        }
    }
}
