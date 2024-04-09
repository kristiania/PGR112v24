package lectures._19;

import lectures._19.database.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WordsExample
{
    public static void main(String[] args) {

        Database database = new Database("files/lectures/19/database.properties");

        try (Connection connection = database.getConnection()) {

            Statement statement = connection.createStatement();

            try {
                int updates = statement.executeUpdate(
                        "INSERT INTO word(word) VALUES('ultra')"
                );

                if (updates > 0) {
                    System.out.println("Ordet ble lagt til!");
                }
            } catch (SQLIntegrityConstraintViolationException e) {
                System.out.println("Ordet finnes allerede i databasen!");
            }

            ResultSet result = statement.executeQuery("SELECT * FROM word;");

            List<String> words = new ArrayList<>();

            while (result.next()) {
                words.add(result.getString(1));
            }

            for (String word : words) {
                System.out.println(word);
            }

            /*
            result.next();
            String word1 = result.getString(1);

            result.next();
            String word2 = result.getString(1);

            result.next();
            String word3 = result.getString(1);

            result.next();
            String word4 = result.getString(1);

            System.out.println(word1);
            System.out.println(word2);
            System.out.println(word3);
            System.out.println(word4);
            */

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
