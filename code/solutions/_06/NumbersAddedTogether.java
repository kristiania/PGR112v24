package solutions._06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


// Oppgave #1
public class NumbersAddedTogether
{
    public static void main(String[] args) {
        int sum = 0;

        File file = new File("files/tasks/06/numbers.txt");

        try {
            Scanner input = new Scanner(file);

            while (input.hasNextInt()) {
                sum += input.nextInt();
            }

            System.out.printf("Sum: %d", sum);

            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Kunne ikke finne 'files/tasks/06/numbers.txt'!");
        }
    }
}

