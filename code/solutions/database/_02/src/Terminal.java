package solutions.database._02.src;


import com.mysql.cj.jdbc.Driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

            Terminal.configuration.load(new FileInputStream("files/tasks/database/terminal/database.properties"));
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Connection getDatabaseConnection() throws Exception {
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


}
