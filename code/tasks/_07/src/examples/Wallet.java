package tasks._07.src.examples;

import java.util.ArrayList;


public class Wallet
{
    ArrayList<ContactCard> cards = new ArrayList<>();

    public void addCard(ContactCard card) {
        this.cards.add(card);
    }

    public void printContactInfo() {
        System.out.println("Contact Info:");

        for (ContactCard card : this.cards) {
            System.out.printf(
                    "+ Name: %s%n-- Email: %s%n-- Phone: (+47) %s%n",
                    card.getName(),
                    card.getEmail(),
                    card.getPhoneNumber() <= 0
                            ? "????????"
                            : card.getPhoneNumber()
            );
        }
    }

    public static void main(String[] args) {
        Wallet wallet = new Wallet();

        ContactCard marcus = new ContactCard(
                "Marcus",
                "marcusalexander.dahl@kristiania.no",
                0
        );

        ContactCard school = new ContactCard(
                "Høyskolen Kristiania",
                "studier@kristiania.no",
                22_59_60_00
        );

        wallet.addCard(school);
        wallet.addCard(marcus);

        wallet.printContactInfo();
    }
}