package solutions.database._04.src;


import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;


public class Terminal
{
    //# Static
    private static final Properties configuration = new Properties();
    private static final Scanner input = new Scanner(System.in);

    static {
        try {
            DriverManager.registerDriver(new Driver());

            Terminal.configuration.load(new FileInputStream("files/tasks/database/_04/database.properties"));

            String[] keys = { "host", "port", "database", "username", "password" };

            for (String key : keys) {
                if (!Terminal.configuration.containsKey(key)) {
                    throw new RuntimeException(STR."The following data is not available: \{key}");
                }
            }

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Connection getDatabaseConnection() throws SQLException {
        String host = Terminal.configuration.getProperty("host");
        String port = Terminal.configuration.getProperty("port");
        String database = Terminal.configuration.getProperty("database");
        String username = Terminal.configuration.getProperty("username");
        String password = Terminal.configuration.getProperty("password");

        // URI: jdbc:mysql://host:port/database
        return DriverManager.getConnection(STR."jdbc:mysql://\{host}:\{port}/\{database}", username, password);
    }


    //# Fields
    private Account currentUser = null;


    //# Methods
    boolean userExists(String username) {
        try (var connection = Terminal.getDatabaseConnection()) {
            /*
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(STR."SELECT id, username FROM account WHERE username = '\{username}';");
            */

            String query = "SELECT id, username FROM account WHERE username = ?;";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, username);

            ResultSet result = statement.executeQuery();

            return result.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    boolean createUser(String username, String password) {
        if (!this.userExists(username)) {
            String hash = solutions.database._03.src.Password.hash(password);

            try (var connection = Terminal.getDatabaseConnection()) {
                /*
                var statement = connection.createStatement();

                String query = STR."INSERT INTO account(username, password) VALUES ('\{username}', '\{hash}');";

                int rowsAffected = statement.executeUpdate(query);
                */

                String query = "INSERT INTO account(username, password) VALUES (?, ?);";

                var statement = connection.prepareStatement(query);

                statement.setString(1, username);
                statement.setString(2, hash);

                int rowsAffected = statement.executeUpdate();

                return rowsAffected > 0;
            } catch (SQLException e) {
                System.out.println(STR."Feilmelding: \{e.getMessage()}");

                return false;
            }
        }

        return false;
    }

    boolean login(String username, String password) {
        if (this.currentUser == null) {
            try (var connection = Terminal.getDatabaseConnection()) {
                /*
                Statement statement = connection.createStatement();

                ResultSet result = statement.executeQuery(STR."SELECT id, username, password FROM account WHERE username = '\{username}';");
                */

                String query = "SELECT id, username, password FROM account WHERE username = ?";

                PreparedStatement statement = connection.prepareStatement(query);

                ResultSet result = statement.executeQuery();

                if (result.next()) {
                    Account account = new Account(username, password);
                    String hashFromDatabase = result.getString("password");

                    if (account.getPassword().equals(hashFromDatabase)) {
                        this.currentUser = account;

                        return true;
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            if (this.currentUser.getUsername().equals(username)) {
                return this.currentUser.getPassword().equals(Password.hash(password));
            }
        }

        return false;
    }

    void showMenu() {
        System.out.println("---");
        System.out.println("Terminalmeny:");
        System.out.println();

        System.out.println(" - 1. Logg inn");
        System.out.println(" - 2. Avslutt");
        System.out.println();

        System.out.print("Valg: ");

        int choice = this.getNumberFromTerminalInput();

        switch (choice) {
            case 1 -> {
                System.out.println();
                System.out.println("Brukernavn: ");

                String username = Terminal.input.nextLine();

                System.out.println("Passord: ");

                String password = Terminal.input.nextLine();

                if (this.login(username, password)) {
                    System.out.println(STR."Du er logget inn som: \{this.currentUser.getUsername()}!");
                }
                else {
                    System.out.println("Feil brukernavn eller passord!");

                    this.showMenu();
                }
            }

            case 2 -> System.exit(0);

            default -> {
                System.out.println("Menyvalg ikke gjenkjent!");

                this.showMenu();
            }
        }
    }

    private int getNumberFromTerminalInput() {
        try {
            return Integer.parseInt(Terminal.input.nextLine());
        } catch (NumberFormatException e) {
            System.out.print("Du må skrive inn et tall! Forsøk igjen: ");

            return getNumberFromTerminalInput();
        }
    }
}
