package solutions._07.example1;

import java.util.ArrayList;
import java.util.HashMap;


public class Bank
{
    private HashMap<Person, ArrayList<Account>> data = new HashMap<>();

    public Account getAccount(Person customer, String name) {
        if (this.customerExists(customer)) {
            for (Account account : this.data.get(customer)) {
                if (account.getName().equals(name)) {
                    return account;
                }
            }
        }

        return null;
    }

    public boolean registerCustomer(Person customer) {
        if (this.customerExists(customer)) {
            return false;
        }
        else {
            this.data.put(customer, new ArrayList<>());
            customer.setBank(this);

            return true;
        }
    }

    private boolean customerExists(Person customer) {
        return this.data.containsKey(customer);
    }

    private boolean customerAccountExists(Person customer, String name) {
        if (this.customerExists(customer)) {
            for (Account account : this.data.get(customer)) {
                if (account.getName().equals(name)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean customerAccountRegistered(Person customer, Account account) {
        if (this.customerExists(customer)) {
            if (this.data.get(customer).contains(account)) {
                return true;
            }
        }

        return false;
    }

    public boolean createAccount(Person customer, String name) {
        return this.createAccount(customer, name, 0);
    }

    public boolean createAccount(Person customer, String name, int balance) {
        if (this.customerAccountExists(customer, name)) {
            this.data.get(customer).add(new Account(customer, name, balance));

            return true;
        }

        return false;
    }

    public boolean addAccount(Person customer, Account account) {
        if (this.customerExists(customer) && this.customerAccountExists(customer, account.getName())) {
            this.data.get(customer).add(account);

            return true;
        }

        return false;
    }

    public ArrayList<Account> getAccounts(Person customer) {
        if (this.customerExists(customer)) {
            return this.data.get(customer);
        }
        else {
            // istedenfor exception, gi en tom liste
            return new ArrayList<>();
        }
    }

    public int getTotalBalance(Person customer) {
        int sum = 0;

        for (Account account : this.data.get(customer)) {
            sum += account.getBalance();
        }

        return sum;
    }

    public boolean transferMoney(Person customer, int money, Account from, Account to) {
        if (this.customerAccountRegistered(customer, from)) {
            if (from.getBalance() >= money) {
                if (this.customerAccountRegistered(customer, to)) {
                    from.setBalance(from.getBalance() - money);
                    to.setBalance(to.getBalance() + money);

                    return true;
                }
            }
        }

        return false;
    }

    public boolean withdrawMoney(Person customer, int money, Account account) {
        if (this.customerAccountRegistered(customer, account)) {
            if (account.getBalance() >= money) {
                if (customer.hasWallet()) {
                    account.setBalance(account.getBalance() - money);

                    Wallet wallet = customer.getWallet();

                    wallet.setBalance(wallet.getBalance() + money);

                    return true;
                }
            }
        }

        return false;
    }
}
