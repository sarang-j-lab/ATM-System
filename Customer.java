import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    String customerName;
    int customerAccountNumber;
    int customerPin;
    int seriesOfAccountNumber = 1001;
    int customerBalance;
    static int initialBalance = 2000;
    ArrayList<Integer> customerTransactions = new ArrayList<>();
    

    public Customer(String name, int pin){
        this.customerName = name;
        this.customerPin = pin;
        this.customerAccountNumber = this.seriesOfAccountNumber++;
        this.customerBalance = this.initialBalance;
        System.out.println(this.customerName + " " + this.customerAccountNumber +" "+ this.customerPin);
        
    }   


    public Customer(String name, int accountNumber,int pin, ArrayList<Integer> transactionHis){
        this.customerName = name;
        this.customerAccountNumber = accountNumber;
        this.customerPin = pin;
        this.customerBalance = this.initialBalance;
        this.customerTransactions = transactionHis;
    }



    public static boolean findCustomer(int accountNumber, ArrayList<Customer> customerList, Scanner input) throws MyExceptions{
        for(Customer c: customerList){
            if (c.customerAccountNumber == accountNumber) {
                System.out.println("Enter pin");

                int pin = input.nextInt();

                boolean pinVarification = (c.customerPin == pin) ? true : false ;

                MajorFeatures.afterVarificationProcess(c, pinVarification, input);
                return true;
            } 
        }
        return false;
    }

   






}
