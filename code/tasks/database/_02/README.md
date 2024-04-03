# Oppgavesett DB_02 - 2024-04-03

> Dette oppgavesettet forventer at du har fullført `DB_01`-oppgavesettet

---

Oppgavene gjøres her: `code/tasks/database/terminal/src`

---

## Oppgave 1

Opprett en klasse som heter `Terminal`;

Denne klassen opprettes med følgende felt:
- `private static Properties configuration = new Properties();`
- `private static Scanner input = new Scanner(System.in);`
- `private Account currentUser = null;`

---

## Oppgave 2

Logg deg på SQL-databasen din via `root`-brukeren og gjør følgende:

1. Opprett en database som heter `terminal`
2. Opprett en bruker som heter `terminal` - velg et passord selv som du husker og bruker videre i oppgavesettet
3. Gi `terminal`-brukeren tilgang til alle tabeller i `terminal`-databasen

---

## Oppgave 3

Finn følgende fil: `code/tasks/database/connection/database.properties`

Legg til de nødvendige nøklene og relevante verdier fra oppgave 2, og lagre endringene gjort i filen

---

> PS! Bruk gjerne kode fra forelesning 18 som referanse med tanke på resten av oppgavene!

---

## Oppgave 4

I `Terminal`-klassen, opprett en statisk kodeblokk om gjør følgende:

1. Registrer MySQL-driveren
2. Laster inn `database.properties` fra oppgave 3 ved hjelp av:
  - `Terminal.configuration.load(new FileInputStream("code/tasks/database/connection/database.properties"))`
3. Kaster en `RuntimeException` dersom en feil oppstår ved enten registrering av driver eller ikke alle nøklene med tilhørende verdier er tilstede i `database.properties`-filen

---

## Oppgave 5

I `Terminal`-klassen, opprett en statisk metode som heter `getDatabaseConnection()`

Denne metoden skal opprette en instanse av `Connection`-klassen ved å bruke `DriverManager.getConnection(...)` og returnere denne.

Denne metoden skal også ha `throws SQLException` som en del av metode signaturen sin.

---

> Fortsettelse følger!