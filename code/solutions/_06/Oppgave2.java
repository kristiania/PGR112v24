package solutions._06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Oppgave2
{
    public static void main(String[] args) {
        ArrayList<Composer> composers = new ArrayList<>();

        File file = new File("files/tasks/06/composers.txt");

        try {
            Scanner input = new Scanner(file);

            String name;
            int birthYear = 0;

            while (input.hasNextLine()) {
                name = input.nextLine();

                if (input.hasNextInt()) {
                    birthYear = input.nextInt();

                    input.skip("\n");
                }

                if (input.hasNextLine()) {
                    input.skip("---");
                }

                composers.add(new Composer(name, birthYear));
            }

            input.close();

            for (Composer composer : composers) {
                System.out.printf(
                        "Composer[name=\"%s\"; birthYear=%d;]%n",
                        composer.getName(), composer.getBirthYear()
                );
            }
        } catch (FileNotFoundException e) {
            System.out.println("Kunne ikke finne 'files/composers.txt'!");
        }
    }
}

