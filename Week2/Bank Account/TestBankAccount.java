public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(200.00, 1000.00);
        BankAccount account2 = new BankAccount(444000, 444000);
        
        // confirming savingsBalance is not accessible:
        // account1.savingsBalance = 3000.0;

        // print tests:

        // check Account1
        System.out.printf("\nAccount 1 Checking balance: $%.2f", account1.getCheckingBalance());
        System.out.printf("\nAccount 1 Savings balance: $%.2f", account1.getSavingsBalance());
        
        // check Account2
        System.out.printf("\nAccount 2 Checking balance: $%.2f", account2.getCheckingBalance());
        System.out.printf("\nAccount 2 Savings balance: $%.2f", account2.getSavingsBalance());
        
        // check deposit and withdrawal methods
        account2.withdraw("Checking", 8800);
        System.out.printf("\nNew checking balance: $%.2f", account2.getCheckingBalance());

        account1.deposit("savings", 500);
        // check over-withdrawal
        account1.withdraw("Checking", 500);
        // System.out.printf("\n");

        // check totalAmount method
        System.out.printf("\nAccount 1 Total Amount: %.2f", account1.getAccountTotal());
        System.out.printf("\nAccount 2 Total Amount: %.2f", account2.getAccountTotal());

        
        // check for NumAccounts & AllAccountsBalance
        System.out.printf("\nNumber of Accounts: %d", BankAccount.getNumAccounts());
        System.out.printf("\nTotal Balance of Accounts: %.2f", BankAccount.getAllAccountsBalance());
    }
}
