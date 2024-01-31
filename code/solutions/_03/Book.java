package solutions._03;

public class Book
{
    //# Fields
    //# -----------------------------------------------------------------------
    // Oppgave #2
    private String title;
    private String author;
    private int numberOfPages;
    private Genre genre; // Oppgave 7

    //# Constructor
    //# -----------------------------------------------------------------------
    // Oppgave #4
    public Book(String title, String author, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    // Oppgave 6
    //# Getters
    //# -----------------------------------------------------------------------
    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getNumberOfPages() {
        return this.numberOfPages;
    }

    // Oppgave 7
    public Genre getGenre() {
        return this.genre;
    }


    //# Setters
    //# -----------------------------------------------------------------------
    private void setTitle(String value) {
        this.title = value;
    }

    private void setAuthor(String value) {
        this.author = value;
    }

    private void setNumberOfPages(int value) {
        this.numberOfPages = value;
    }

    private void setGenre(Genre value) {
        this.genre = value;
    }


    //# Methods
    //# -----------------------------------------------------------------------
    // Oppgave #3
    public void printInfo() {
        System.out.println("Informasjon om denne boken:");
        System.out.printf("- Tittel: %s", this.title);
        System.out.printf("- Forfatter: %s", this.author);
        System.out.printf("- Antall sider: %d", this.numberOfPages);
    }
}
