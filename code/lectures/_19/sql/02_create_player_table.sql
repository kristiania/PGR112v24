CREATE TABLE player(
    id                  INT AUTO_INCREMENT,
    moniker             VARCHAR(255) UNIQUE NOT NULL,
    health_current      INT UNSIGNED NOT NULL DEFAULT 10,
    health_max          INT UNSIGNED NOT NULL DEFAULT 10,
    coins               INT UNSIGNED NOT NULL DEFAULT 100,
    experience          INT UNSIGNED NOT NULL DEFAULT 0,
    level               INT UNSIGNED NOT NULL DEFAULT 1,
    PRIMARY KEY(id)
);
