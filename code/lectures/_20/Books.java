package lectures._20;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Books
{
    private static final Database database = new Database("files/lectures/20/database.properties");

    public static Book createBook(String title, String author, long ISBN) throws SQLException {
        var connection = Books.database.getConnection();

        String query = "INSERT INTO book(title, author, ISBN) VALUES (?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

        statement.setString(1, title);
        statement.setString(2, author);
        statement.setLong(3, ISBN);

        int updates = statement.executeUpdate();

        if (updates > 0) {
            ResultSet keys = statement.getGeneratedKeys();

            keys.next();

            int id = keys.getInt(1);

            return new Book(id, title, author, ISBN);
        }

        return null;
    }

    // Håndtere alle bøker
    public static void main(String[] args) throws SQLException {
        var book1 = Books.createBook("Tilfeldig tittel", "Tilfeldig forfatter", 123321123L);

        if (book1 != null) {
            System.out.print("Bokens tittel: ");
            System.out.println(book1.title());
        }

        /*
        // Her lager vi Book-objekter manuelt
        var book1 = new Book(
                1,
                "Bokens tittel",
                "Bokens forfatter",
                1234567L
        );

        var book2 = new Book(
                2,
                "Bok Nr. 2",
                "Ukjent Forfatter",
                8123712316L
        );
        */

    }
}
