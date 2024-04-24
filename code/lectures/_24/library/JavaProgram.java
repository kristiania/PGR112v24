package lectures._24.library;


public class JavaProgram
{
    public static void main(String[] args) {
        Library library = new Library();

        Book book = new Book(
                "Den første boken",
                "Den første forfatteren",
                "Den første boken som ble skrevet noensinne",
                100,
                10000000000L,
                10
        );

        library.addBook(book);

        library.removeBook(book);
    }
}
