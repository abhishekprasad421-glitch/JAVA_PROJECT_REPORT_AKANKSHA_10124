class Wallet {
    double balance = 0;   // simple variable

    // deposit money
    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposited: " + amount);
        }
    }

    // transfer money
    void transfer(Wallet w, double amount) {
        if (amount > 0 && balance >= amount) {
            balance = balance - amount;
            w.balance = w.balance + amount;

            // cashback 2%
            double cashback = amount * 0.02;
            balance = balance + cashback;

            System.out.println("Transfer successful");
            System.out.println("Cashback: " + cashback);
        } else {
            System.out.println("Transfer failed");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Wallet w1 = new Wallet();
        Wallet w2 = new Wallet();

        w1.deposit(1000);

        System.out.println("W1 Balance: " + w1.balance);

        w1.transfer(w2, 300);

        System.out.println("W1 Balance: " + w1.balance);
        System.out.println("W2 Balance: " + w2.balance);
    }
}

// OUTPUT
//  Deposited: 1000.0
//  W1 Balance: 1000.0
//  Transfer successful
//  Cashback: 6.0
//  W1 Balance: 706.0
//W2 Balance: 300.0