package lectures._06.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class JavaProgram
{
    public static void main(String[] args) {
        File fileObject = new File("files/06/forelesning.txt");

        try {
            Scanner input = new Scanner(fileObject);

            while(input.hasNextLine()) {
                String line = input.nextLine();

                if (!line.isEmpty()) {
                    System.out.println(line);
                }
            }

            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
