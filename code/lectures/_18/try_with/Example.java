package lectures._18.try_with;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Example
{

    public static void main(String[] args) {

        try (Scanner input = new Scanner(new File("files/examples/java/scanner/file.txt"))) {

            String line = input.nextLine();

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
