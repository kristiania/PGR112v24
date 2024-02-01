package solutions._07.example1;

import java.util.ArrayList;

public class Person
{
    private String name = "Ukjent";
    private Bank bank = null;
    private Wallet wallet = null;

    //# Getter-methods
    public String getName() {
        return this.name;
    }

    public Bank getBank() {
        return this.bank;
    }

    public Wallet getWallet() {
        return this.wallet;
    }

    public ArrayList<Account> getAccounts() {
        return this.getBank().getAccounts(this);
    }

    //# Setter-methods
    public void setName(String value) {
        this.name = name;
    }

    public void setBank(Bank value) {
        this.bank = value;
    }

    public void setWallet(Wallet value) {
        this.wallet = value;
    }

    //# Methods
    public boolean hasBank() {
        return this.bank != null;
    }

    public boolean hasWallet() {
        return this.wallet != null;
    }
}
