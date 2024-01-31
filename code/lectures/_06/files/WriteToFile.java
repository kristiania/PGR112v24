package lectures._06.files;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile
{
    public static void main(String[] args) {
        try {
            FileWriter output = new FileWriter("files/06/output.data");

            output.write("Dette er linje 1\nDette er linje 2\n");
            output.write("Dette er linje 3\n");
            output.close();

            System.out.println("Filen ble skrevet til!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
