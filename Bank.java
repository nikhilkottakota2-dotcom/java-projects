import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;

class Customer{
    int customerid;
    String name;
    String address;
    String phonenumber;
    ArrayList<Account>accounts;

    Customer(int customerid, String name, String address, String phonenumber){
        this.customerid = customerid;
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
        this.accounts = new ArrayList<>();
    }

    int getCustomerId(){
        return customerid;
    }

    String getCustomerName(){
        return name;
    }

    String getAddress(){
        return address;
    }

    String getPhoneNumber(){
        return phonenumber;
    }
    void displaycustmer(){
        System.out.println("Customer id:"+customerid);
        System.out.println("Customer name:"+name);
        System.out.println("Address:"+address);
        System.out.println("Phone number of the customer:"+phonenumber);
    }
}
class Account{
    String accountnumber;
    int customerid;
    double balance;
    public Account(String accountnumber,int customerid,double balance){
        this.accountnumber = accountnumber;
        this.customerid = customerid;
        this.balance = balance;
    }
    String getaccountnumber(){
        return accountnumber;
    }
    double getbalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
        } else {
            System.out.println("Invalid amount to deposit");
        }
    }
    public void withdraw(double amount){
        if(amount > 0 && balance >= amount){
            balance -= amount;
        } else {
            System.out.println("There is not enough money in the account");
        }
    }
    void displayAccountdetails(){
        System.out.println("Account number: " + accountnumber);
        System.out.println("Customer id: " + customerid);
        System.out.println("Balance: " + balance);
    }
}
class Transaction{
    int transactionId;
    String accountnumber;
    double amount;
    String type;
    Date date;
    public Transaction(int transactionId, String accountnumber, double amount, String type){
        this.transactionId = transactionId;
        this.accountnumber = accountnumber;
        this.amount = amount;
        this.type = type;
        this.date = new Date();
    }
    void displayTransaction(){
        System.out.println("Transaction id: "+transactionId);
        System.out.println("Account Number: "+accountnumber);
        System.out.println("Amount: "+amount);
        System.out.println("Type of Transaction: "+type);
        System.out.println("Date of the Transaction: "+date);
    }
    
}

class bank{
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Account> accounts = new ArrayList<>();
    ArrayList<Transaction> transactions = new ArrayList<>();
    public bank(){
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
    }
}
public class Bank{
    public static void main(String []args){
        
    }
}