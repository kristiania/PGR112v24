CREATE DATABASE lecture19;

CREATE USER 'lecture19'@'localhost' IDENTIFIED BY 'password19';

GRANT ALL PRIVILEGES ON lecture19.* TO 'lecture19'@'localhost';
