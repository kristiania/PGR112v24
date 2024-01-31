package lectures._04;

public class Wallet {
    //# Fields
    private Bank bank;
    private int coins;

    //# Constructor
    Wallet(Bank bank) {
        this.bank = bank;

        this.empty();
    }

    //# Method
    public int getCoins() {
        return this.coins;
    }

    public void empty() {
        if (this.bank.withdraw(this, this.getCoins())) {
            System.out.println("Wallet is now empty");
        }
    }

    public void addCoins(int value) {
        this.bank.deposit(this, value);
    }

    public boolean removeCoins(int value) {
        if (this.bank.balance(this) - value >= 0) {
            return this.bank.withdraw(this, value);
        }

        return false;
    }
}
