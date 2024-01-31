package solutions._05;

import java.util.ArrayList;
import java.util.Scanner;

public class InteractiveTerminal
{
    public static void main(String[] args) {
        ArrayList<String> options = new ArrayList<>();

        options.add("Valg #1");
        options.add("Valg #2");
        options.add("Valg #3");

        System.out.println("Meny:");
        for (int i = 0; i < options.size(); i ++) {
            System.out.printf(" - %d) %s%n", i + 1, options.get(i));
        }

        System.out.println();
        System.out.print("Ditt valg: ");

        Scanner input = new Scanner(System.in);

        String choice = input.nextLine();

        switch (choice) {
            case "1":
            case "2":
            case "3":
                System.out.printf("Du valgte %s!%n", choice);
                break;

            default:
                System.out.println("Valget ditt eksisterer ikke!");
        }
    }
}
