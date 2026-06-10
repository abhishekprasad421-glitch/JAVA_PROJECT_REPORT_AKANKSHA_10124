class Wallet {
    // Private balance (Encapsulation)
    private double balance;

    // Static cashback rate shared by all wallets
    static double cashbackRate = 0.02; // 2%

    // Getter method
    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Transfer method with exception handling
    public void transferTo(Wallet receiver, double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid amount");
            }

            if (balance < amount) {
                throw new Exception("Insufficient balance");
            }

            balance -= amount;
            receiver.balance += amount;

            double cashback = amount * cashbackRate;
            balance += cashback;

            System.out.println("Transaction successful. Cashback: " + cashback);

        } catch (Exception e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}

public class DigitalWalletDemo {
    public static void main(String[] args) {

        Wallet w1 = new Wallet();
        Wallet w2 = new Wallet();

        w1.deposit(1000);

        System.out.println("Before Transfer:");
        System.out.println("Wallet 1 Balance: " + w1.getBalance());
        System.out.println("Wallet 2 Balance: " + w2.getBalance());

        w1.transferTo(w2, 300);

        System.out.println("\nAfter Transfer:");
        System.out.println("Wallet 1 Balance: " + w1.getBalance());
        System.out.println("Wallet 2 Balance: " + w2.getBalance());
    }
}

//output

// Before Transfer:
// Wallet 1 Balance: 1000.0
// Wallet 2 Balance: 0.0
// Transaction successful. Cashback: 6.0

// After Transfer:
// Wallet 1 Balance: 706.0
// Wallet 2 Balance: 300.0
 