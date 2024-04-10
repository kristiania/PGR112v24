CREATE DATABASE lecture20;

CREATE USER 'lecture20'@'localhost' IDENTIFIED BY 'password20';

GRANT ALL PRIVILEGES ON lecture20.* TO 'lecture20'@'localhost';
