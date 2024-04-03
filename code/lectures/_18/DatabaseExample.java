package lectures._18;

import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;


public class DatabaseExample
{
    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Properties database = new Properties();

        try {
            database.load(new FileInputStream("files/lectures/18/database.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (!database.keySet().containsAll(List.of("host", "port", "database", "username", "password"))) {
            System.out.print("Keys found: ");
            System.out.println(database.keySet());

            throw new RuntimeException("Missing information to connect to database");
        }

        try {
            Connection connection = DriverManager.getConnection(
                    STR."\{"jdbc:mysql://%s:%s/%s".formatted(
                            database.getProperty("host"),
                            database.getProperty("port"),
                            database.getProperty("database")
                    )}?allowPublicKeyRetrieval=true&useSSL=false",
                    database.getProperty("username"),
                    database.getProperty("password")
            );

            DatabaseExample.useConnection(connection);

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void useConnection(Connection connection) throws SQLException {
        Statement query = connection.createStatement();

        ResultSet result = query.executeQuery("SELECT 1 + 2;");

        result.next();

        System.out.print("Query result: ");
        System.out.println(result.getInt(1));
    }
}
