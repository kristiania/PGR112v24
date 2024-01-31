package solutions._05;

import java.util.ArrayList;
import java.util.Scanner;

public class Questions
{
    public static void main(String[] args) {
        ArrayList<String> questions = new ArrayList<>();

        questions.add("Hva er navnet ditt?");
        questions.add("Hvor gammel er du?");

        ArrayList<String> answers = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        for (String question : questions) {
            System.out.print(question + " ");

            answers.add(input.nextLine());
        }

        System.out.println("Spørsmål og svar:");

        for (int i = 0; i < answers.size(); i ++) {
            System.out.println("---");
            System.out.printf("- Spørsmål: %s%n", questions.get(i));
            System.out.printf("- Svar: %s%n", answers.get(i));
        }
    }
}

