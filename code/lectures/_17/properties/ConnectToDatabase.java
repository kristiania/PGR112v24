package lectures._17.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConnectToDatabase
{
    public static void main(String[] args) throws UsernameNotFound, PasswordNotFound {
        Properties database = new Properties();

        try {
            database.load(new FileInputStream("files/lectures/17/database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!database.getProperty("username").isEmpty()) {
            System.out.print("Username: ");
            System.out.println(database.getProperty("username"));
        }
        else {
            throw new UsernameNotFound();
        }

        if (!database.getProperty("password").isEmpty()) {
            System.out.print("Password: ");
            System.out.println(database.getProperty("password"));
        }
        else {
            throw new PasswordNotFound();
        }


    }

    static class UsernameNotFound extends Exception {
        public UsernameNotFound() {
            super("Brukernavn ikke funnet i database.properties");
        }
    }

    static class PasswordNotFound extends Exception {
        public PasswordNotFound() {
            super("Brukernavn ikke funnet i database.properties");
        }
    }
}
