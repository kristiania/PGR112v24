USE lecture22;

CREATE TABLE product(
    id              INT AUTO_INCREMENT,
    name            VARCHAR(255) NOT NULL,
    description     VARCHAR(255) DEFAULT '',
    price           INT DEFAULT 0,
    PRIMARY KEY (id)
);