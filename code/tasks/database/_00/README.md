# Oppgavesett DB_00 - 2024-04-02

> Forberedelser til forelesning 18 og det å begynne med databaser!

---

## Oppgave 1

Før vi kan jobbe med databaser ved hjelp av programmering og kode, er vi nødt til å ha tilgang til en database.

Sørg for å ha MySQL eller MariaDB installert på din maskin, og tilgang til ditt root-passord før du går videre!

---

## Oppgave 2

Disse stegene kan du gjøre i terminalen via `mysql -u root -p` eller MySQL Workbench, hvor oppgaven går ut på følgende:

Logg inn som `root` og utfør følgende:

1. Opprett en database som heter: `lecture18`

2. Opprett en bruker som heter `Lecture18` med følgende passord: `Password18`

3. Denne brukeren skal ha tilgang til alt av tabeller i `lecture18`-databasen

> For å gjøre disse 3 stegene, kjør følgende SQL-uttrykk:

1. `CREATE DATABASE lecture18;`
2. `CREATE USER 'lecture18'@'localhost' IDENTIFIED BY 'password18';`
3. `GRANT PRIVILEGE ON lecture18.* TO 'lecture18'@'localhost';`

For å sjekke om det fungerer som det skal, logg inn på MySQL-serveren på nytt med nytt brukernavn og passord istedenfor `root`-brukeren!

F.eks. `mysql -u lecture18 -p`

---

## Oppgave 3

Denne oppgaven kan gjøres i et eget prosjekt eller ved å bruke `files/`-mappen, for eksempelvis her: `files/tasks/database/_00/database.properties`

Opprett en tom tekstfil som heter `database.properties` som inneholder følgende:

```properties
username=lecture18
password=password18
```

Deretter bruk følgende to kodelinjer som et utgangspunkt for å hente disse verdiene ut via kode:

```java
Properties properties = new Properties();

properties.load(new FileInputStream("files/tasks/database/_00/database.properties"));
```

Og deretter forsøk å hente ut verdiene for brukernavn og passord ved hjelp av f.eks. `properties.getProperty("username");`

Husk å sjekke evt. Exceptions som kan oppstå ved å sjekke for `IOException`.

## Oppgave 4

Opprett 3 nye Exceptions (ved hjelp av arv og Exception-klassen) for følgende 3 situasjoner:

- `database.properties`-filen eksisterer ikke og denne må opprettes for at programmet skal kunne kjøpre
- Brukernavnet kunne ikke leses av og programmet kan ikke fortsette uten
- Passordet kunne ikke leses av og programmer kan ikke fortsette uten

Gjøre endringer i koden fra Oppgave 3 slik at disse Exceptions-ene blir kastet når de ulike situasjonene oppstår

