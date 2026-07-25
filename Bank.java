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

class BankSystem{
    ArrayList<Customer> customers;
    ArrayList<Account> accounts;
    ArrayList<Transaction> transactions;
    private int nextTransactionId = 1;

    public BankSystem(){
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public void addCustomer(Customer c){
        customers.add(c);
    }

    public Customer findCustomerById(int id){
        for(Customer c: customers){
            if(c.getCustomerId() == id) return c;
        }
        return null;
    }

    public Account findAccountByNumber(String accNo){
        for(Account a: accounts){
            if(a.getaccountnumber().equals(accNo)) return a;
        }
        return null;
    }

    public boolean createAccount(String accNo, int customerId, double initialDeposit){
        Customer c = findCustomerById(customerId);
        if(c == null) return false;
        if(findAccountByNumber(accNo) != null) return false;
        Account a = new Account(accNo, customerId, initialDeposit);
        accounts.add(a);
        c.accounts.add(a);
        if(initialDeposit > 0) {
            transactions.add(new Transaction(nextTransactionId++, accNo, initialDeposit, "Deposit"));
        }
        return true;
    }

    public boolean deposit(String accNo, double amount){
        Account a = findAccountByNumber(accNo);
        if(a == null) return false;
        a.deposit(amount);
        transactions.add(new Transaction(nextTransactionId++, accNo, amount, "Deposit"));
        return true;
    }

    public boolean withdraw(String accNo, double amount){
        Account a = findAccountByNumber(accNo);
        if(a == null) return false;
        if(a.getbalance() < amount) return false;
        a.withdraw(amount);
        transactions.add(new Transaction(nextTransactionId++, accNo, amount, "Withdraw"));
        return true;
    }

    public void showAllCustomers(){
        for(Customer c: customers){
            c.displaycustmer();
            System.out.println("---");
        }
    }

    public void showAllAccounts(){
        for(Account a: accounts){
            a.displayAccountdetails();
            System.out.println("---");
        }
    }

    public void showAllTransactions(){
        for(Transaction t: transactions){
            t.displayTransaction();
            System.out.println("---");
        }
    }
}

public class Bank{
    public static void main(String []args){
        BankSystem bank = new BankSystem();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Add customer");
            System.out.println("2. Create account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. List customers");
            System.out.println("6. List accounts");
            System.out.println("7. List transactions");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            String opt = sc.nextLine().trim();
            switch(opt){
                case "1":
                    try{
                        System.out.print("Customer id (int): ");
                        int id = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Name: ");
                        String name = sc.nextLine().trim();
                        System.out.print("Address: ");
                        String address = sc.nextLine().trim();
                        System.out.print("Phone number: ");
                        String phone = sc.nextLine().trim();
                        if(bank.findCustomerById(id) != null){
                            System.out.println("Customer with that id already exists.");
                        } else {
                            bank.addCustomer(new Customer(id, name, address, phone));
                            System.out.println("Customer added.");
                        }
                    } catch(NumberFormatException e){
                        System.out.println("Invalid id format.");
                    }
                    break;
                case "2":
                    System.out.print("Account number: ");
                    String accNo = sc.nextLine().trim();
                    try{
                        System.out.print("Customer id: ");
                        int cid = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Initial deposit: ");
                        double dep = Double.parseDouble(sc.nextLine().trim());
                        boolean ok = bank.createAccount(accNo, cid, dep);
                        System.out.println(ok ? "Account created." : "Failed to create account. Check customer id or account number.");
                    } catch(NumberFormatException e){
                        System.out.println("Invalid numeric input.");
                    }
                    break;
                case "3":
                    System.out.print("Account number: ");
                    String accD = sc.nextLine().trim();
                    try{
                        System.out.print("Amount: ");
                        double amt = Double.parseDouble(sc.nextLine().trim());
                        boolean ok = bank.deposit(accD, amt);
                        System.out.println(ok ? "Deposit completed." : "Deposit failed. Check account number.");
                    } catch(NumberFormatException e){
                        System.out.println("Invalid amount.");
                    }
                    break;
                case "4":
                    System.out.print("Account number: ");
                    String accW = sc.nextLine().trim();
                    try{
                        System.out.print("Amount: ");
                        double amtw = Double.parseDouble(sc.nextLine().trim());
                        boolean ok = bank.withdraw(accW, amtw);
                        System.out.println(ok ? "Withdrawal completed." : "Withdrawal failed. Check account or balance.");
                    } catch(NumberFormatException e){
                        System.out.println("Invalid amount.");
                    }
                    break;
                case "5":
                    bank.showAllCustomers();
                    break;
                case "6":
                    bank.showAllAccounts();
                    break;
                case "7":
                    bank.showAllTransactions();
                    break;
                case "8":
                    running = false;
                    break;
                default:
                    System.out.println("Unknown option.");
            }
        }
        sc.close();
        System.out.println("Goodbye.");
    }
}