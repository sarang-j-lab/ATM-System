import java.util.ArrayList;
import java.util.Scanner;

/*
 * 
 * 
 * 
 * 
 * 
 * The Main class is use to run the whole program from one place
 * it will initiat the user interaction first it will take customer 
 * account number if it is not exists then it will give option to activate
 * thier ATM card  and if it is active then check for ATM pin validation.
 */
public class Main {
    public static void main(String[] args) throws MyExceptions {
        ArrayList<Customer> customerList = new ArrayList<>();

        System.out.println("Enter your account number");

        ArrayList<Integer> hardCodedTransactions = new ArrayList<>();
        hardCodedTransactions.add(1000);
        hardCodedTransactions.add(2500);
        hardCodedTransactions.add(-500);

        Customer c1 = new Customer("sarang", 1000, 100,hardCodedTransactions);
        customerList.add(c1);

        Scanner input = new Scanner(System.in);

        int accountNumber = input.nextInt();

        
            if (!Customer.findCustomer(accountNumber,customerList,input)) {
                System.out.println("Customer with this account number is not exists\nActivate you account(yes/no)");
                String permission = input.next();

                MajorFeatures.createCustomer(permission, input, customerList);

                System.out.println(customerList);
        
            } 
        

    }

 

    
}