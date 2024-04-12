# Løsningsforslag DB_03

> Endelig løsningsforslag som tar for seg DB_01, DB_02, DB_03 og DB_04 samlet sett finner du her: `code/solutions/database/terminal/`

> Koden du finner i dette løsningsforslaget løser kun DB_03 (som baserer seg på DB_01 og DB_02)

---

Oppgave 1 ble løst ved å opprette følgende fil: `code/tasks/database/_02/sql/02_create_account_table.sql`

Oppgave 2 ble løst ved å logge inn i databasen som `terminal`-brukeren og deretter ved å kjøre følgende SQL-uttrykk:
- Se fil: `./sql/02_create_account_table.sql`

Oppgave 3 ble løst ved å kjøre følgende SQL-uttrykk:
- Se fil: `./sql/03_insert_admin_account.sql`

For å sjekke om oppgave 3 ble utført, ble `SELECT * FROM account;` kjørt som et SQL-uttrykk hvor det sjekkes om `admin`-brukeren returneres eller ikke.

Oppgave 4 ble gjort ved å opprette en metode med navn `userExists(String username)` som returnerer `boolean` basert på om brukeren eksisterer eller ikke.
- Linjenummer: `55`

Følgende kode løste oppgave 4:

```java
    boolean userExists(String username) {
        try (var connection = Terminal.getDatabaseConnection()) {
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(STR."SELECT id, username FROM account WHERE username = '\{username}';");

            return result.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
```

Her returneres `result.next()` da denne metoden beveger pekeren til `ResultSet`-instansen til neste tilgjengelige rad,
og dersom vi fikk en rad tilbake med data om en eksisterende bruker, så finnes det en rad som denne metoden kan flytte pekeren til,
og dermed returnere `true` dersom dette er tilfellet, og dersom det ikke er en rad tilgjengelig, returneres `false`

Oppgave 5 ble løst ved å opprette metoden `createUser(String username, String password)` i `Terminal`-klassen
- Linjenummer: `67`

Følgende kode ble brukt:

```java
    boolean createUser(String username, String password) {
        // eksisterer brukeren fra før av eller ikke?
        if (!this.userExists(username)) {
            // vi hasher passordet da brukeren ikke eksisterer og vi skal nå lage en bruker
            String hash = Password.hash(password);
            
            // henter en tilkobling til databasen
            try (var connection = Terminal.getDatabaseConnection()) {
                // gjør klart et SQL-uttrykk som kan kjøres
                var statement = connection.createStatement();
                // hvor følgende er uttrykket som vil bli brukt
                String query = STR."INSERT INTO account(username, password) VALUES('\{username}', '\{hash}');";
                
                // vi kjører uttrykket ved hjelp av `.executeUpdate(...) da denne returnerer antall rader påvirket
                int updates = statement.executeUpdate(query);
                
                // her returneres det om det skjedde en oppdatering (bruker lagt til) eller ikke
                return updates > 0;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
        // da en bruker ikke har blitt opprettet (return updates > 0; ble aldri kjørt), returnerer vi false
        return false;
    }
```

Koden ble testet ved å opprette en klasse som heter `Main` som inneholder kun en statisk main-metode.

Oppgave 6 ble løst ved å:
1. lage en getter-metode i `Account`-klassen som returnerer passordet. Her velges pakkebasert tilgangsmodifikator (altså, ingen eksplisitt tilgangsmodifiktor som f.eks. public) da vi ønsker kun at klasse i pakken (mappen koden er i) skal ha tilgang.
2. lager en metode i `Account`-klassen som skal håndtere innlogging av bruker, med navn `login(...)`

Koden ble som følger for `login(...)`-metoden:

```java
    boolean login(String username, String password) {
        // er det en bruker logget inn eller ikke? Fortsetter dersom ikke
        if (this.currentUser == null) {
            // henter database tilkobling
            try (var connection = Terminal.getDatabaseConnection()) {
                // gjør klar et uttrykk som kan kjøres
                Statement statement = connection.createStatement();
                // Henter hashet passord lagret i databasen
                ResultSet result = statement.executeQuery(STR."SELECT password FROM account WHERE username = '\{username}';");

                // dersom det finnes en rad å bevege pekeren til, fortsetter vi
                if (result.next()) {
                    // oppretter en instans av Account-klassen
                    Account account = new Account(username, password);
                    // henter passordet hashet fra databasen
                    String hashFromDatabase = result.getString("password");

                    // er passord oppgitt det samme som det som er i databasen?
                    if (account.getPassword().equals(hashFromDatabase)) {
                        // dersom dette stemmer, setter vi nåværende bruker til å være objektet vi opprettet
                        // objektets levetid endres her, istedenfor at variabelen fjernes etter metoden er ferdig
                        // å kjøre, så lever objektet videre lagret i feltet!
                        this.currentUser = account;

                        // brukeren ble logget inn, og vi returnerer da true
                        return true;
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        // dersom det allerede er en bruker logget inn
        } else {
            // så sjekker vi om brukernavn oppgitt samsvarer
            if (this.currentUser.getUsername().equals(username)) {
                // og deretter returnerer resultatet av å sammenligne passord oppgitt med passordet til innlogget bruker
                return this.currentUser.getPassword().equals(Password.hash(password));
            }
        }

        // i alle andre tilfeller, så kan vi anta at innlogging ikke sjekket og at brukeren som er logget inn
        // ikke samsvarer med innloggingsdetaljer oppgitt, og returnerer da false
        return false;
    }
```

Oppgave 7 ble løst ved å lage en metode i `Terminal`-klassen som har ansvaret for å vise en meny,
og deretter starte prosessen med å hente inn det brukeren av terminalen skriver inn ved hjelp av `Scanner`-objektet lagret via statisk felt

Metoden opprettet heter `showMenu()` og tar for seg det å:
1. presentere menyen
2. håndtere menyvalg

Sjekk ut koden fra linjenummer 120. Hvordan menyen presenteres er opp til deg!

---

Løsningsforslag til ekstra-oppgavene legges ut på et senere tidspunkt. 