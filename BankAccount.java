 public class BankAccount {
    double balance = 0.0;
    
    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        balance -= amount;
    }
    double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(100);
        System.out.println("Balance: " + account.getBalance());
        account.withdraw(30);
        System.out.println("Balance: " + account.getBalance());

    }
 }