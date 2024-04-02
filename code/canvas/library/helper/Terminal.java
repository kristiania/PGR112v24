package canvas.library.helper;

import java.time.LocalDate;
import java.time.LocalTime;


public class Terminal
{
    public static void log(String context, String message) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        String timestamp = time.toString();

        System.out.printf(
                "[%s][%s][%s]: %s%n",
                date,
                timestamp.substring(0, timestamp.indexOf('.')),
                context,
                message
        );
    }
}
