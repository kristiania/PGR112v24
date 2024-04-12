USE terminal;

CREATE TABLE account(
    id          INT UNSIGNED AUTO_INCREMENT,
    username    VARCHAR(255) UNIQUE,
    password    VARCHAR(255),
    PRIMARY KEY(id)
);