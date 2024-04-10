# Oppgavesett DB_04 - 2024-04-10

> Dette oppgavesettet forventer at du har fullført `DB_03`-oppgavesettet

---

Oppgavene gjøres her: `code/tasks/database/terminal/src/`

---

## Oppgave 1

Gå tilbake til oppgavesettet DB_03 og sjekk fra oppgave 4 og utover.

Identifiser hvilke av oppgavene som trenger endringer med tanke på sikkerhet.
Disse oppgavene trenger at vi bruker `PreparedStatement` istedenfor `Statement`.

Svar på følgende spørsmål:

1. Hvilke oppgaver trenger at vi bruker `PreparedStatement` istedenfor?

2. Når burde vi bruke `PreparedStatement` istedenfor `Statement`?

**Hint 1**: Se etter `boolean userExists(...)`-metoden og hvordan SQL-uttrykket et satt opp. 

**Hint 2**: `Statement` er gjerne for å kjøre uttrykk som ikke endrer på seg eller trengs å tilpasses basert på data.

---

## Oppgave 2

Gjør nødvendige endringer i oppgavene identifisert i oppgave 1, altså:

- Gå igjennom oppgavene å endre bruken fra `Statement` til `PreparedStatement` hvor det trengs.

Du kan bruke følgende kodesnutt som et eksempel og kontekst med hva som menes:

```java
// Her antas det at vi har en `connection`-variabel av typen `Connection` allerede
int id = 123;

//# Statement
Statement statement = connection.createStatement();
ResultSet result = statement.executeQuery(STR."SELECT * FROM table WHERE id = \{id};");

//# PreparedStatement
String query = "SELECT * FROM table WHERE id = ?;";
PreparedStatement statement = statement.prepareStatement();

statement.setInt(1, id);

ResultSet result = statement.executeQuery();
```