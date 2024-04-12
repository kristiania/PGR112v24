# Oppretter en database som heter `terminal`
CREATE DATABASE terminal;

# Oppretter en bruker som heter `terminal`
CREATE USER 'terminal'@'localhost' IDENTIFIED BY 'terminal';

# Gir `terminal`-brukeren tilgang til alle tabeller i `terminal`-databasen
GRANT ALL PRIVILEGES ON terminal.* TO 'terminal'@'localhost';
