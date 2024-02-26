package examples.java.scanner;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class InputFromFile
{
    public static void main(String[] args) {
        String filePath = "files/examples/java/scanner/file.txt";
        File file = new File(filePath);

        try {
            Scanner input = new Scanner(file);

            // Gå igjennom hver linje og print ut noe info
            int lineNumber = 1;

            while(input.hasNextLine()) {
                String line = input.nextLine();

                System.out.println(STR."Linje \{lineNumber ++}: \"\{line}\"");
                System.out.printf("- Antall karakterer: %d%n", line.length());
                System.out.printf("- Første karakter: %s%n", line.charAt(0));
                System.out.printf("- Siste karakter: %s%n", line.charAt(line.length() - 1));

                System.out.println();
            }

            // Si ifra til OS at vi er ferdig med filen
            input.close();

        } catch (FileNotFoundException e) {
            System.out.println(STR."Kunne ikke finne følgende fil: \{filePath}");
        }
    }
}
