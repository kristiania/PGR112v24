package lectures._20;


/*
    id INT AUTO_INCREMENT,
     title VARCHAR(255) NOT NULL,
     author VARCHAR(255) NOT NULL,
     ISBN BIGINT UNIQUE NOT NULL,
 */
public record Book(int id, String title, String author, long ISBN) {}

/*

public class Book
{

}

*/