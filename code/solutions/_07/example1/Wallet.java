package solutions._07.example1;

public class Wallet
{
    private Person owner;
    private int balance;

    public Wallet(Person owner) {
        this.setOwner(owner);
        this.setBalance(0);
    }

    public Person getOwner() {
        return this.owner;
    }

    public int getBalance() {
        return this.balance;
    }

    private void setOwner(Person value) {
        this.owner = value;
    }

    public void setBalance(int value) {
        this.balance = value;
    }
}
