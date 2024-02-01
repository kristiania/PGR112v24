package solutions._07.example1;

public class Account
{
    private Person owner;
    private String name;
    private int balance;

    public Account(Person owner, String name) {
        this(owner, name, 0);
    }

    public Account(Person owner, String name, int balance) {
        this.setOwner(owner);
        this.setName(name);
        this.setBalance(balance);
    }

    public Person getOwner() {
        return this.owner;
    }

    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return this.balance;
    }

    private void setOwner(Person value) {
        this.owner = value;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setBalance(int value) {
        this.balance = value;
    }
}
