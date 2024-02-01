package solutions._07.example3;

import java.time.LocalTime;

public class Watch
{
    public String getCurrentTime() {
        LocalTime time = LocalTime.now();

        // kun interessert i HH:MM = 5 tegn
        return time.toString().substring(0, 5);
    }
}
