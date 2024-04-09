USE lecture19;

CREATE TABLE user(
    id INT AUTO_INCREMENT,
    username VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO user(username, email) VALUES('mada051', 'MarcusAlexander.Dahl@kristiania.no');
INSERT INTO user(username, email) VALUES('MarcusAlexander.Dahl', 'mada051@egms.no');