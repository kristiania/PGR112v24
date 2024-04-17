package lectures._22;

import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;


public class Database
{
    //# Static
    static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //# Fields
    private final Properties properties = new Properties();

    {
        // Standard-verdier
        this.properties.put("host", "localhost");
        this.properties.put("port", "3306");
    }


    //# Constructors
    public Database(String filePath) {
        // Laster inn informasjon fra .properties-fil oppgitt
        try {
            this.properties.load(new FileInputStream(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Nøkkeldata som trengs for å kunne koble seg til en database
        List<String> keysNeeded = List.of(
                "host", "port", "database", "username", "password"
        );

        // Sjekker at vi har all nødvendig informasjon
        if (!this.properties.keySet().containsAll(keysNeeded)) {
            System.out.print("Keys that exist: ");
            System.out.println(this.properties.keySet());

            throw new RuntimeException("Missing information to connect to database!");
        }
    }


    //# Methods
    public Connection getConnection() throws SQLException {
        // URI: jdbc:mysql://host:port/database
        return DriverManager.getConnection(
                STR."\{"jdbc:mysql://%s:%s/%s".formatted(
                        this.properties.getProperty("host"),
                        this.properties.getProperty("port"),
                        this.properties.getProperty("database")
                )}?allowPublicKeyRetrieval=true&useSSL=false",
                this.properties.getProperty("username"),
                this.properties.getProperty("password")
        );
    }
}
