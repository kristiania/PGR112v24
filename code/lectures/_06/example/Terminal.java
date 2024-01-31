package lectures._06.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

public class Terminal
{
    private String prefix;

    public Terminal(String prefix) {
        this.prefix = prefix;
    }

    public void log(String message) {
        LocalTime time = LocalTime.now();
        String line = "[" + this.prefix + "][" + time + "]: " + message;

        try {
            FileWriter output = new FileWriter("files/log.txt", true);

            output.write(line + "\n");
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(line);
    }
}
