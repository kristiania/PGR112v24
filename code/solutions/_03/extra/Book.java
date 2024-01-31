package solutions._03.extra;

import solutions._03.Genre;


public class Book
{
    //# Fields
    private String title;
    private String author;
    private int numberOfPages;
    private Genre genre;


    //# Constructor
    public Book(String title, String author, int numberOfPages, Genre genre) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setNumberOfPages(numberOfPages);
        this.setGenre(genre);
    }


    //# Getters
    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getNumberOfPages() {
        return this.numberOfPages;
    }

    public Genre getGenre() {
        return this.genre;
    }


    //# Setters
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
    public void printInformation() {
        /*
            %s = tekst
            %d = desimaltall (base 10)
            %n = ny linje, typ. \n
        */
        System.out.println("Information about the book:");
        System.out.printf("- Title: %s%n", this.getTitle());
        System.out.printf("- Author: %s%n", this.getAuthor());
        System.out.printf("- Number of pages: %d%n", this.getNumberOfPages());
        System.out.printf("- Genre: %s%n", this.getGenre());
    }

    @Override
    public String toString() {
        return "Book[title=%s; author=%s; numberOfPages=%d; genre=%s]".formatted(
                this.getTitle(),
                this.getAuthor(),
                this.getNumberOfPages(),
                this.getGenre()
        );
    }
}
