# Oppgavesett DB_03 - 2024-04-05

> Dette oppgavesettet forventer at du har fullført `DB_02`-oppgavesettet

---

Oppgavene gjøres her: `code/tasks/database/terminal/src/`

---

## Oppgave 1

Før vi kan forholde oss til brukernavn og passord som kan brukes til å logge inn i en terminal,
trenger vi at denne dataen kan lagres i en database.

Opprett en mappe/pakke som heter `sql` slik at du får følgende mappestruktur: `code/tasks/database/terminal/sql/`, og opprett følgende fil: `create_account_table.sql`;

```sql
CREATE TABLE account(
    id          INT UNSIGNED AUTO_INCREMENT,
    username    VARCHAR(255) UNIQUE,
    password    VARCHAR(255),
    PRIMARY KEY(id)
);
```

## Oppgave 2

Vi trenger da å få opprettet denne tabellen i databasen, og vi har 3 måter å gå fram på her:

1. Vi oppretter tabellen manuelt i databasen via terminalen, IntelliJ eller MySQL Workbench.
2. Vi oppretter tabellen via programkode, altse ved å kjøre Java-kode.

La oss gjøre nr. 1 under for å så gjøre nr. 2 i en senere oppgave;

---

> Velg en av de tre under-oppgavene under:

---

### Oppgave 2.1 -- `terminal`

Her er det to måter å gjøre dette på, via `mysql`-kommandoen direkte eller etter en har logget inn via `mysql`.

#### Via `mysql`-kommandoen direkte:

1. Inne i IntelliJ, høyre-klikk `code/tasks/database/terminal/sql` og velg `Copy Path/Reference` og deretter `Absolute Path`
2. Inne i et terminal-vindu, skriv in `cd ` (med mellomrom etter) og lim inn den absolutte filbanen fra forrige steg og kjør
3. Følgende kommando kjøres da får å importere inn `.sql`-filen:
    - `mysql -u terminal -p terminal < create_account_table.sql`

#### Via terminalen etter du er logget inn via `mysql`:

1. Inne i et terminal-vindue, logg inn som `terminal`-brukeren: `mysql -u terminal -p`
2. Om du ser `mysql >` er du nå inne i kommandolinjeverktøyet og kan kjøre spørringer direkte;
3. Du kan nå skrive inn SQL-spørring som befinner seg inne i `code/tasks/database/terminal/sql/create_account_table.sql`-filen (du kan også kopiere og lime inn).


---

### Oppgave 2.2 -- `MySQL Workbench`

1. Åpne opp `MySQL Workbench` og koble deg til databasen via `terminal`-brukeren
2. I en spørrings-fane (identifisert ved hjelp av et lyn-ikon), så kan du kjøre spørringen fra: `code/tasks/database/terminal/sql/create_account_table.sql`-filen


---

### Oppgave 2.3 -- `IntelliJ`

> Krever `IntelliJ Ultimate Edition`

1. Klikk på database-ikonet helt til høyre, vanligvis nummer 3 i listen.
2. Om du ikke har lagt til en datakilde enda (det vises ingen `localhost` i listen), trykk på `+`-ikonet og legg til en MySQL datakilde
3. Høyreklikk datakilden du opprettet og velg `Query Console`
4. I denne konsollen kan du kjøre SQL-uttrykk og spørringer opp mot databasen;
   - Kjør innholdet fra `code/tasks/database/terminal/sql/create_account_table.sql`-filen

---

> For å sjekke om hele oppgave 2 er gjort, altså at `account`-tabellen ble opprettet, kan du gjøre følgende spørringer:

```sql
USE terminal;
DESCRIBE account;
```

Får du opp skjemaet fra `CREATE TABLE`-uttrykket kjørt tidligere?

---

> Følgende oppgaver gjøres etter du har tabellen `account`-tabellen opprettet i databasen:

---

## Oppgave 3

La oss lage en admin-bruker!

Først, la oss lage et passord. Bruk en statisk main-metode i en midlertidig klasse, og kjør: `Password.hash("et passord to velger selv");`

Følgende String-verdi gjelder for `admin` som et passord: `jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=`

Kjør følgende SQL-uttrykk opp mot databasen:

```sql
# Her erstatter du passordet med det du lagde selv, med mindre du ønsker å fortsette med `admin:admin` som innlogging
INSERT INTO account(username, password) VALUES ('admin', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=');
```

Kjør følgende uttrykk for å sjekke om admin-brukeren ble lagt til:

```sql
SELECT * FROM account;
```

Får du `id`, `username` og `password` printet ut i en tabell med `id` satt til å være 1? Da er du klar for neste oppgave.

---

## Oppgave 4

Nå trenger vi å sjekke om en bruker eksisterer eller ikke før vi forsøker å logge inn en bruker som skriver inn riktig brukernavn og passord.

> **MERK!** Dette er ikke en sikker måte å gjøre det på! Hvordan vi gjør det helt sikkert ser vi på i forelesning 20! 

Begynne med følgende metode i `Terminal`-klassen som et utgangspunkt:

```java


   boolean userExists(String username) {
       try (Connection connection = Terminal.getDatabaseConnection()) {
           Statement statement = connection.createStatement();

           // OBS! Følgende er ikke en trygg måte å gjøre det på, men fungerer for nå!
           ResultSet result = statement.executeQuery(STR."SELECT id, username FROM account WHERE username = '\{username}';");
           
           // Her må du kode slik at vi sjekker at vi fikk et resultat eller ikke fra spørringen over!
           // Returner "true" dersom vi fikk 1 rad tilbake fra databasen
           
       } catch (SQLException e) {
           e.printStackTrace();
       }
       
       // om vi ikke returnerer "true" eller en feil oppstår, kan vi anta at brukeren ikke eksisterer
       return false;
   }
```

> **Hint 1**: `ResultSet` starter pekeren sin ved å se på rad 0 (som er før allt eventuelle resultater).
> For å flytte pekeren til rad 1, så trenger vi å kalle på en metode.
> Hva returnerer denne metoden (tenk: data-type)? Kan vi bruke denne retur-verdien for å sjekke om det er en verdi tilstede i neste rad, om det er en rad vi kan lese av som neste rad?

> **Hint 2**: For å flytte pekeren til _neste_ rad, så må vi kalle på metoden som heter..? Og hva returnerer denne metoden?

---

## Oppgave 5

I denne oppgaven skal du lage en bruker!

Bruk følgende metode som et utgangspunkt i `Terminal`-klassen:

```java
    // ta utgangspunkt i psuedo-koden under
    boolean createUser(String username, String password) {
        // Check if username exists
            // 1 hash password 
            // 2 get database connection
            // 3 create a statement
            // 4 run .executeUpdate(...) instead of .executeQuery(...)
                // figure out what .executeUpdate(...) returns
                // can this return value be used to decide if a row was added to the database or not?
            // 5 check if row was inserted or not, if so, return true
       
        // Else, if username does not exists, return false
    }
```

Sjekk gjerne om brukeren ble lagt til ved å kjøre en `SELECT`-spørring eller via `userExists(...)` 

---

## Oppgave 6

Gjør følgende endring i `Account`-klassen:

- Lag en getter-metode som returnerer passordet (som skal være hashet!) som en String-verdi
- Tilgangsmodifikator kan settes til å være ingenting (som vil si pakke-basert tilgang)

Lag følgende metode i `Terminal`-klassen:

- `boolean login(String username, String password)`
  - Oppretter et objekt av `Account`-klassen: `new Account(username, password)`
  - Sjekk opp mot databasen at passordet fra `Account`-objektet samsvarer med passordet lagret i databasen
    - Hint: bruk gjerne `.userExists(...)` som referanse
  - Dersom brukernavn og passord samsvarer, set `this.currentUser` til å være `Account`-objektet
  - Metoden skal returnere true eller false avhengig av om brukeren ble logget inn eller ikke.
  - Om en bruker allerede er logget inn (`this.currentUser != null`), _og_, kun dersom brukernavn og passord da samsvarer med bruker logget inn, returner true

---

## Oppgave 7

Lag en enkel terminal-meny som har 2 valg til å begynne med:

1. Logg inn
   - Dersom brukernavn og passord er riktig, vis en melding at innloggingen var vellykket
   - Dersom brukernavn og passord er feil, vis en melding om at brukernavn eller passord er feil, og send de tilbake til menyen med de to innledende valgene
2. Avslutt
   - Programmet avsluttes, f.eks. ved å kjøre kodesnutten `System.exit(0);`

---

> Oppgavene under er ekstra oppgaver:

---

## Ekstra-oppgave

Lag en mulighet for at dersom du er logget inn som `admin`-brukeren at du får følgende meny-valg:

1. Liste over alle brukere
2. Legg til bruker
3. Slett bruker
4. Logg ut

Vis gjerne meny-valget for å logge ut for alle andre enn `admin`-brukeren også

Fullfør meny-valgene slik at det er mulig å utføre det meny-valgene lar deg velge!

> Hint 1.: Bruk gjerne .next() inne i en while-loop, litt på lik linje med while (input.hasNextLine()) når vi leser av en fil med flere linjer!

> Hint 2.: Her må administrator skrive inn brukernavn og passord, og få det passordet som er hashet printet ut til terminalen slik at det kan deles/tests 

> Hint 3.: Her må du bruke en `DELETE`-spørring. Istedenfor .executeQuery(...) kan du sjekke resultatet fra .executeUpdate(...) for å lettere sjekke om en oppdatering i databasen (bruker fjernet) skjedde eller ikke!

---

## Avsluttningsvis

> I et senere oppgavesett kommer du tilbake til dette oppgavesettet for å sikre kodebasen din for å hindre bl.a. SQL Injection!
> 
> Forelesning 20 tar for oss hvordan vi kan håndtere dette på en sikrere måte hvor vi går dypere inn på temaet "Hvordan beskytte din database" i forelesning 22