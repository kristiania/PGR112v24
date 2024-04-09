CREATE DATABASE lecture18;

CREATE USER 'lecture18' IDENTIFIED BY 'password18';

GRANT ALL PRIVILEGES ON lecture18.* TO 'lecture18'@'localhost';