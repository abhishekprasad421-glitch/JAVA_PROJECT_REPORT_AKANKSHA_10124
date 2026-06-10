class Wallet {
    private double balance;
    static double cashbackRate = 0.02; // 2% cashback

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        try {
            if (amount <= 0) {
                throw new Exception("Invalid deposit amount");
            }

            balance += amount;
            System.out.println("Deposited: " + amount);

        } catch (Exception e) {
            System.out.println("Deposit Failed: " + e.getMessage());
        }
    }

    public void transferTo(Wallet receiver, double amount) {
        try {
            if (amount <= 0) {
                throw new Exception("Invalid transfer amount");
            }

            if (balance < amount) {
                throw new Exception("Insufficient balance");
            }

            balance -= amount;
            receiver.balance += amount;

            double cashback = amount * cashbackRate;
            balance += cashback;

            System.out.println("Transaction Successful");
            System.out.println("Cashback Received: " + cashback);

        } catch (Exception e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        }
    }
}

public class DigitalWalletDemo {
    public static void main(String[] args) {

        Wallet w1 = new Wallet();
        Wallet w2 = new Wallet();

        w1.deposit(1000);

        System.out.println("Wallet 1 Balance: " + w1.getBalance());
        System.out.println("Wallet 2 Balance: " + w2.getBalance());

        w1.transferTo(w2, 300);

        System.out.println("\nAfter Transfer:");
        System.out.println("Wallet 1 Balance: " + w1.getBalance());
        System.out.println("Wallet 2 Balance: " + w2.getBalance());
    }
}


// output

// Deposited: 1000.0
// Wallet 1 Balance: 1000.0
// Wallet 2 Balance: 0.0
// Transaction Successful
// Cashback Received: 6.0

// After Transfer:
// Wallet 1 Balance: 706.0
// Wallet 2 Balance: 300.0
