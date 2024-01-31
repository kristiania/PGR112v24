package solutions._03.extra;

import solutions._03.Genre;

public class JavaProgram
{
    public static void main(String[] args) {
        Book book = new Book("Title", "Author", 123, Genre.OTHER);

        book.printInformation();

        //# Her brukes .toString()-metoden for å konvertere objektet til en tilpasset String-verdi
        System.out.println(book);
    }
}
