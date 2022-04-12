public class BankAccount {
    // ATTRIBUTES/MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;
    // number of accounts created:
    private static int numAccounts = 0;
    // total amount of money stored in all accounts:
    private static double allAccountsBalance = 0.0;

    // CONSTRUCTOR
    public BankAccount(double checkingBalance, double savingsBalance){
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        allAccountsBalance += checkingBalance + savingsBalance;
        numAccounts++;
    }

    // METHODS
    // deposit into savings or checking account
    public void deposit(String accountType, double amount){
        if((accountType == "checking") | (accountType == "Checking")){
            this.checkingBalance += amount;
            allAccountsBalance += amount;
            System.out.printf("\nNew Checking Account Balance: $%.2f", this.checkingBalance);
        }
        if((accountType == "savings") | (accountType == "Savings")){
            this.savingsBalance += amount;
            allAccountsBalance += amount;
            System.out.printf("\nNew Savings Account Balance: $%.2f", this.savingsBalance);

        }
        else{
            System.out.println("\nPlease specify an account: Checking or Savings");
        }
    }

    // withdraw from savings or checking account
    // void if insufficient funds
    public void withdraw(String accountType, double amount){
        if((accountType == "checking") | (accountType == "Checking")){
            if(this.checkingBalance < amount){
                System.out.println("\nUnable to withdraw: insufficient funds");
            }
            else{
                this.checkingBalance -= amount;
                allAccountsBalance -= amount;
                System.out.printf("\nNew Checking Account Balance: $%.2f", this.checkingBalance);

            }
        if((accountType == "savings") | (accountType == "Savings")){
            if(this.savingsBalance < amount){
                System.out.println("\nUnable to withdraw: insufficient funds");
            }
            else{
                this.savingsBalance -= amount;
                allAccountsBalance -= amount;
                System.out.printf("\nNew Savings Account Balance: $%.2f", this.savingsBalance);
            }
        }
        }
    }

    public double getAccountTotal(){
        double totalAmount = this.checkingBalance + this.savingsBalance;
        return totalAmount;
    }

    // GETTERS
    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public static double getAllAccountsBalance() {
        return allAccountsBalance;
    }

    public static int getNumAccounts() {
        return numAccounts;
    }
}
