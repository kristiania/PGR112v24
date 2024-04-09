package lectures._19;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsersExample
{
    public static void main(String[] args) {
        Database database = new Database("files/lectures/19/database.properties");

        try (Connection connection = database.getConnection()) {

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM user;");

            ArrayList<User> users = new ArrayList<>();

            while (result.next()) {
                /*
                System.out.printf("ID: %d%n", result.getInt("id"));
                System.out.printf("Brukernavn: %s%n", result.getString(2));
                System.out.printf("E-mail: %s%n", result.getString(3));
                 */

                System.out.println(STR."ID: \{result.getInt("id")}");
                System.out.println(STR."Brukernavn: \{result.getString("username")}");
                System.out.println(STR."E-mail: \{result.getString("email")}");

                users.add(new User(result.getInt("id"), result.getString(2), result.getString(3)));
            }

            System.out.println("---");

            System.out.print("Amount of users: ");
            System.out.println(users.size());

            System.out.println(users.get(1).email);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static class User {
        private int id;
        private String username;
        private String email;

        public User(int id, String username, String email) {
            this.id = id;
            this.username = username;
            this.email = email;
        }
    }
}
