package solutions._07.example1;

public class JavaProgram
{
    public static void main(String[] args) {
        Bank bank = new Bank();
        Person person = new Person();

        person.setName("Kronesamleren");

        bank.registerCustomer(person);

        bank.createAccount(person, "Inn");
        bank.createAccount(person, "Ut");

        Account savings = new Account(
                person,
                "Sparekonto",
                10_000
        );

        bank.addAccount(person, savings);

        Account moneyIn = bank.getAccount(person, "Inn");
        Account moneyOut = bank.getAccount(person, "Ut");

        if (!person.hasWallet()) {
            person.setWallet(new Wallet(person));
        }

        System.out.printf("%nFør:%n");
        System.out.printf("Sparekonto: kr %d,-%n".formatted(savings.getBalance()));
        System.out.printf("Inn: kr %d,-%n".formatted(moneyIn.getBalance()));
        System.out.printf("Ut: kr %d,-%n".formatted(moneyOut.getBalance()));
        System.out.printf("Lommebok: kr %d,-%n".formatted(person.getWallet().getBalance()));

        bank.transferMoney(
                person,
                1000,
                savings,
                moneyIn
        );

        bank.transferMoney(
                person,
                550,
                moneyIn,
                moneyOut
        );



        bank.withdrawMoney(person, 500, moneyOut);

        System.out.printf("%nEtter:%n");
        System.out.printf("Sparekonto: kr %d,-%n".formatted(savings.getBalance()));
        System.out.printf("Inn: kr %d,-%n".formatted(moneyIn.getBalance()));
        System.out.printf("Ut: kr %d,-%n".formatted(moneyOut.getBalance()));
        System.out.printf("Lommebok: kr %d,-%n".formatted(person.getWallet().getBalance()));
    }
}
