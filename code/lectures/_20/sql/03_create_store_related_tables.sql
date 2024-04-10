USE lecture20;

CREATE TABLE product(
    id          INT AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL,
    price       INT UNSIGNED DEFAULT 0,
    PRIMARY KEY(id)
);