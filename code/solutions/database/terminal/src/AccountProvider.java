package solutions.database.terminal.src;

import java.sql.SQLException;
import java.util.ArrayList;

public class AccountProvider
{
    private final Terminal terminal;


    public AccountProvider(Terminal terminal) {
        this.terminal = terminal;
    }


    ArrayList<String> getUsernames() throws SQLException {
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
