# Oppgavesett DB_05

> Dette oppgavesettet er litt vag for å tvinge deg til å finne ut av hva som skal gjøres i hver oppgave:

> Oppgaven kan gjøres her: `code/tasks/database/_05/src/`, hvor du kan dokumentere hvilke SQL-uttrykk du kjører underveis her: `code/tasks/database/_05/sql/` ved å opprette `.sql`-filer - bruk fjerne beskrivende navn på filene!

---

## Oppgave 1:

Opprett en database som heter `questions`

---

## Oppgave 2:

Opprett følgende innlogging til `questions`-databasen hvor formatet under er `brukernavn:passord`:

```
question:answer
```

Sørg også for at denne brukeren har tilgang til alle tabeller i `questions`-databasen

---

## Oppgave 3:

Opprett `question`- og `answer`-tabellene ved å kjøre følgende:

```sql
USE questions;

CREATE TABLE question(
    id                  INT AUTO_INCREMENT,
    question            VARCHAR(255) UNIQUE NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE answer(
    id                  INT AUTO_INCREMENT,
    answer              VARCHAR(255) NOT NULL,
    question            INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (question) REFERENCES question(id)
);
```

## Oppgave 4:

Lag en klasse som heter `QuestionsAndAnswers` plassert her:
- `code/tasks/database/_04/src/`

Start med en statisk main-metode som for nå printer ut `Spørsmål og svar!` til terminalen.

---

## Oppgave 5

> Denne oppgaven er stor og er ledende for hvordan resten av oppgaven skal løses:

---

> Husk! Bruk gjerne deg selv når du tenker igjennom hvordan du ville gått igjennom programmets flyt,
> typ. du må se for deg selv som brukeren som forholder seg til spørsmål og svar slik som beskrevet i oppgaven!
 
---

Oppgaven går ut på at en bruker starter en terminal-applikasjon, og får følgende meny til å begynne med:

```
1. Søk etter spørsmål
2. Registrer spørsmål
3. Registrere svar på spørsmål
4. Se svar på spørsmål
5. Avslutt
```

Applikasjonen går ut på følgende: En bruker skal kunne registrere spørsmål og deretter kunne registrere et eller flere svar tilknyttet et spørsmål.

Spørsmål er unike, og kan ha flere svar tilknyttet spørsmålet.

### 1. Søk etter spørsmål

Her skal brukeren kunne søke etter registrerte spørsmål, ved å for eksempel kunne søke etter nøkkelord (et konkret ord som er en del av et spørsmål),
eller ved å søke etter deler av et spørsmål.

Bruk gjerne følgende SQL-uttrykk som et utgangspunkt:

```java
String query = "SELECT id, question FROM question WHERE question LIKE ?";

var statement = connection.prepareStatement(query);

statement.setString(1, "%" + search + "%");
```

Les gjerne https://www.w3schools.com/sql/sql_like.asp med tanke på bruk av `%` ved bruk av `LIKE`-operatøren i et `WHERE`-utrykk for å se etter tekst som inneholder det vi ser etter.

Her antas det at variabelen `search` er et parameter eller en variabel som inneholder det brukeren skrev inn som skulle søkes etter.

Vis relevante spørsmål sammen med id-nummeret, da id nummeretet brukes gjerne for å svare på spørsmål enklere

### 2. Registrer spørsmål

Her skal brukeren kunne registrere et nytt spørsmål. Om spørsmålet er allerede lagret i databasen (spørsmålet er helt identisk med et allerede lagret spørsmål), så skal brukeren informeres om dette.

Etter spørsmålet er registrert skal brukeren få opp 2 valg:

```
1. Svar på spørsmålet
2. Gå tilbake
```

Valg av `1` skal la brukeren svare direkte på spørsmålet slik at svaret knyttes til spørsmålet (Husk fremmednøkkelen i `answer`-tabellen)

Valg av `2` tar brukeren tilbake til menyen som ble presentert innledningsvis

---

### 3. Registrere svar på spørsmål

Her skal brukeren:
- Skrive inn id-nummeret til et spørsmål
- Spørsmålet printes ut dersom spørsmålet finnes
  - Brukeren skriver inn svaret på spørsmålet
  - Svaret lagres i databasen
- eller, om spørsmålet ikke finnes, si i fra til brukeren og tilbake til starten av programmet

---

### 4. Se svar på spørsmål

Brukeren skriver inn spørsmål id-nummer og får listet opp all svarene tilknyttet spørsmålet

---

### 5. Avslutt

Avslutter programmet ved å kjøre `System.exit(0);`

---

## Tips og triks

Ha følgende i bakhodet: Er det lettere om spørsmålet er lagret som uppercase i databasen?

Bruk også gjerne følgende `interface` som et forslag til metoder du kan ende opp med å opprette:

```java
interface QuestionsAndAnswersApplication {
    //# Henter alle spørsmål
    // question.id, Question.instance
    Map<Integer, Question> getQuestions();
    
    //# Henter alle spørsmål basert på ord/deler av spørsmålet en søker etter
    Map<Integer, Question> getQuestions(String searchTerm);
    
    //# Henter alle svar tilknyttet id-nummeret for et spørsmål
    // question.id, Answer-instance
    HashMap<Integer, Answer> getAnswers(int question);
    
    //# Registrer et spørsmål dersom det ikke er lagret i databasen fra før av
    boolean registerQuestion(String question);
    
    //# Registrer et spørsmål opp mot et spørsmål gitt et id-nummer som representerer spørsmålet 
    boolean registerAnswer(int question, String answer);
}
```
