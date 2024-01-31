package solutions._05.extra;

import java.util.ArrayList;
import java.util.Scanner;


public class InteractiveTerminal
{
    public static void main(String[] args) {
        ArrayList<String> options = new ArrayList<>();

        options.add("Bruk rød tekst");
        options.add("Bruk grønn tekst");
        options.add("Bruk blå tekst");

        System.out.println("Hvilke farger ønsker du at teksten skal være? ");

        for (int i = 0; i < options.size(); i ++) {
            System.out.printf(" - %d) %s%n", i + 1, options.get(i));
        }

        System.out.println();
        System.out.print("Ditt valg: ");

        String COLOR_RESET = "\u001B[30m";
        String COLOR_RED = "\u001B[31m";
        String COLOR_GREEN = "\u001B[32m";
        String COLOR_BLUE = "\u001B[34m";

        String format = "%sDu valgte %d!%s%n";

        boolean keepAsking = true;

        while (keepAsking) {
            int choice = InteractiveTerminal.getChoiceAsNumberFromUser();

            keepAsking = false;

            switch (choice) {
                case 1 -> System.out.printf(format, COLOR_RED, choice, COLOR_RESET);
                case 2 -> System.out.printf(format, COLOR_GREEN, choice, COLOR_RESET);
                case 3 -> System.out.printf(format, COLOR_BLUE, choice, COLOR_RESET);
                default -> {
                    System.out.println("Valg-mulighet ikke funnet!");
                    System.out.print("Prøv på nytt: ");

                    keepAsking = true;
                }
            }
        }
    }

    private static int getChoiceAsNumberFromUser() {
        Scanner input = new Scanner(System.in);

        String choice = input.nextLine();

        return switch (choice) {
            case "1" -> 1;
            case "2" -> 2;
            case "3" -> 3;
            default -> 0;
        };
    }
}
