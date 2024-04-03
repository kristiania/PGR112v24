CREATE TABLE IF NOT EXISTS words
(
    id   INT AUTO_INCREMENT,
    word VARCHAR(64),
    PRIMARY KEY(id)
);


INSERT INTO words(word) VALUES ('hello');
INSERT INTO words(word) VALUES ('world');


CREATE TABLE store
(
    id INT AUTO_INCREMENT,
    name VARCHAR(128),
    email VARCHAR(128),
    PRIMARY KEY(id)
);