package lectures._17.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Example
{
    public static void main(String[] args) {
        Properties lecture17 = new Properties();

        try {
            lecture17.load(new FileInputStream("files/lectures/17/lecture.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Lecture: ");
        System.out.println(lecture17.getProperty("number"));

        System.out.print("Date: ");
        System.out.println(lecture17.getProperty("date"));
    }
}
