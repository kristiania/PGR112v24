package lectures._03;

import lectures._04.Wallet;

public class Person
{
    private String name;
    private Wallet wallet;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Wallet getWallet() {
        return this.wallet;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setWallet(Wallet object) {
        this.wallet = object;
    }


}
