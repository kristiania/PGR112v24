package lectures._04;

public class Bank
{
    //# Fields
    // Gold
    private int coins = 0;

    public int getCoins() {
        return this.coins;
    }
    public void deposit(Wallet owner, int coins) {
        this.coins += coins;
        // owner.(coins);
    }

    public boolean withdraw(Wallet owner, int coins) {
        if (owner.getCoins() - coins < 0) {
            return false;
        }
        else {
            this.coins -= coins;
            return true;
        }
    }

    public void register(Wallet owner) {

    }

    public int balance(Wallet owner) {
        return owner.getCoins();
    }
}
