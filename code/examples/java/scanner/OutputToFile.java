package examples.java.scanner;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class OutputToFile
{
    public static void main(String[] args) {
        String filePath = "files/examples/java/scanner/output.txt";
        File file = new File(filePath);

        if (file.exists()) {
            System.out.println(STR."Følgende fil eksisterer: \{filePath}");
        }
        else {
            System.out.println(STR."Følgende fil ekisterer ikke: \{filePath}");
        }

        // Legg merke til annerledes try () {}-syntaks
        // Dette kalles for try-with
        // Hvor ressursen vi oppretter inne i parantesen automatisk
        // lukkes, slik at vi ikke trenger å tenke på å kalle på .close()

        System.out.println("Skriv følgende tall til filen: 1, 2, 3");
        try (FileWriter output = new FileWriter(file)) {
            for (int i = 1; i <= 3; i ++) {
                output.write("%d%n".formatted(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Skriv følgende tall til filen: 1, 2, 3, 4, 5");
        try (FileWriter output = new FileWriter(file)) {
            for (int i = 1; i <= 5; i ++) {
                output.write("%d%n".formatted(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Legg merke til true-verdien som andre argument
        // til FileWriter-konstruktøren: append = true
        System.out.println("Legger til følgende tall til filen: 6, 7, 8, 9, 10");
        try (FileWriter output = new FileWriter(file, true)) {
            for (int i = 6; i <= 10; i ++) {
                output.write("%d%n".formatted(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
