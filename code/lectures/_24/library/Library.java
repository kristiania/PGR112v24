package lectures._24.library;

import java.sql.*;
import java.util.HashMap;

public class Library
{
    //# Static
    static final Database database = new Database(
            "files/lectures/24/database.properties"
    );

    //# Fields
    private final HashMap<Long, Book> books = new HashMap<>();


    //# Helper  methods
    public boolean bookExistsInDatabase(Book book) {
        return this.bookExistsInDatabase(book.ISBN());
    }

    public boolean bookExistsInDatabase(long ISBN) {
        try (Connection connection = Library.database.getConnection()) {

            String query = "SELECT * FROM library_book WHERE isbn = ?;";

            var statement = connection.prepareStatement(query);

            statement.setLong(1, ISBN);

            return statement.executeQuery().next();

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //# Methods
    // Create
    public boolean addBook(Book book) {
        if (!this.bookExistsInDatabase(book)) {
            String query = "INSERT INTO library_book(isbn, name, author, description, amountOfPages, rating) VALUES(?, ?, ?, ?, ?, ?)";

            try (Connection connection = Library.database.getConnection()) {

                PreparedStatement statement = connection.prepareStatement(query);

                statement.setLong(1, book.ISBN());
                statement.setString(2, book.name());
                statement.setString(3, book.author());
                statement.setString(4, book.description());
                statement.setInt(5, book.amountOfPages());
                statement.setInt(6, book.rating());

                statement.execute();

                this.books.put(book.ISBN(), book);

                return true;

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return false;
    }

    // Read
    public Book getBook(long ISBN) {
        if (this.books.containsKey(ISBN)) {
            return this.books.get(ISBN);
        }
        else if (this.bookExistsInDatabase(ISBN)) {
            String query = "SELECT * FROM library_book WHERE isbn = '%d';".formatted(ISBN);

            try (Connection connection = Library.database.getConnection()) {

                Statement statement = connection.createStatement();

                ResultSet rs = statement.executeQuery(query);

                Book output = new Book(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("author"),
                        rs.getInt("amountOfPages"),
                        rs.getLong("isbn"),
                        rs.getInt("rating")
                );

                this.books.put(output.ISBN(), output);

                return output;

            } catch (SQLException e) {
               e.printStackTrace();
            }
        }

        return null;
    }

    public HashMap<Long, Book> getAllBooks() {
        HashMap<Long, Book> output = new HashMap<>();

        try (Connection connection = Library.database.getConnection()) {

            Statement statement = connection.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM library_book;");

            while (results.next()) {
                Book book = new Book(
                        results.getString("name"),
                        results.getString("author"),
                        results.getString("description"),
                        results.getInt("amountOfPages"),
                        results.getLong("isbn"),
                        results.getInt("rating")
                );

                output.put(book.ISBN(), book);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    // Update
    public void updateBook(Book book) {
        String query = ""
            + "UPDATE library_book SET "
                + "name = ?, "
                + "description = ?, "
                + "author = ?, "
                + "amountOfPages = ?, "
                + "rating = ? "
            + "WHERE ISBN = ?;"
        ;

        try (Connection connection = Library.database.getConnection()) {

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, book.name());
            statement.setString(2, book.description());
            statement.setString(3, book.author());
            statement.setInt(4, book.amountOfPages());
            statement.setInt(5, book.rating());

            statement.setLong(6, book.ISBN());

            statement.execute();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void removeBook(Book book) {
        this.removeBook(book.ISBN());
    }

    public void removeBook(long ISBN) {
        if (this.bookExistsInDatabase(ISBN)) {
            String query = "DELETE FROM library_book WHERE isbn = ?;";

            try (Connection connection = Library.database.getConnection()) {

                PreparedStatement statement = connection.prepareStatement(query);

                statement.setLong(1, ISBN);

                statement.execute();

            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }




}
