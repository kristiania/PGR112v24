USE lecture24;

CREATE TABLE IF NOT EXISTS library_book(
    isbn BIGINT,
    name VARCHAR(64),
    author VARCHAR(128),
    description VARCHAR(256),
    amountOfPages INT,
    rating INT,

    PRIMARY KEY(isbn)
)