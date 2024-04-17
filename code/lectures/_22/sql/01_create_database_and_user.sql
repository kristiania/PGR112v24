CREATE DATABASE lecture22;

CREATE USER 'lecture22'@'localhost' IDENTIFIED BY 'password22';

GRANT ALL PRIVILEGES ON lecture22.* TO 'lecture22'@'localhost';
