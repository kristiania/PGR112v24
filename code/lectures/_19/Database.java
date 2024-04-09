package lectures._19;


import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class Database
{
    static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final Properties properties = new Properties();


    public Database(String filePath) {
        // Laster inn nøkkeldata fra oppgitt filbane
        try {
            this.properties.load(new FileInputStream(filePath));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        // Sjekke at nøklene ble lastet inn fra filen
        if (!this.properties.keySet().containsAll(List.of("host", "port", "database", "username", "password"))) {
            System.out.print("Keys found: ");
            System.out.println(this.properties.keySet());

            throw new RuntimeException("Missing information to connect to database");
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                STR."jdbc:mysql://\{this.properties.getProperty("host")}:\{this.properties.getProperty("port")}/\{this.properties.getProperty("database")}?allowPublicKeyRetrieval=true&useSSL=false",
                this.properties.getProperty("username"),
                this.properties.getProperty("password")
        );
    }

    public static void main(String[] args) {
        Database database = new Database("files/lectures/18/database.properties");

        try (Connection connection = database.getConnection()) {

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT 1 + 2;");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
