package solutions.database.terminal.src;

import solutions._07.example1.Account;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountProvider
{
    private final Terminal terminal;


    public AccountProvider(Terminal terminal) {
        this.terminal = terminal;
    }


    Map<Integer, String> getUsers() throws SQLException {
        var connection = Terminal.getDatabaseConnection();
        var statement = connection.createStatement();

        var result = statement.executeQuery("SELECT id, username FROM account;");

        var output = new HashMap<Integer, String>();

        while (result.next()) {
            output.put(
                    result.getInt("id"),
                    result.getString("username")
            );
        }

        return output;
    }


    List<String> getUsernames() throws SQLException {
        var connection = Terminal.getDatabaseConnection();
        var statement = connection.createStatement();

        var result = statement.executeQuery("SELECT username FROM account;");

        var output = new ArrayList<String>();

        while (result.next()) {
            output.add(result.getString("username"));
        }

        return output;
    }
}
