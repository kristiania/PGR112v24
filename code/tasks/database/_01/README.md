# Oppgavesett DB_01 - 2024-04-03

> Oppgaver går ut på det å få satt opp en kodebase hvor bruk av database implementeres etter alt er klart 
> og utvides videre i senere oppgavesett

---

## Oppgave 1

- Opprett en klasse som heter `Account`.
  - Denne klassen skal ha følgende felter:
    - `private final String username`
    - `private String password`
  - Denne klassen skal ha følgende metoder:
    - `String getName()`
    - `void setPassword(String value)`
    - `boolean verifyPassword(String value)`

`getName()`-metoden skal returnere verdien lagret i `username`-feltet, hvor `setPassword()` og `verifyPassword()` implementeres i oppgave 2

---

## Oppgave 2

Utforsk følgende kodesnutt ved å få den til å kjøre i en statisk main-metode:

```java
String input = "password";

MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
byte[] bytes = algorithm.digest(input.getBytes(StandardCharsets.UTF_8));

String output = Base64.getEncoder().encodeToString(bytes);

System.out.println(output); // XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=
```

---

### Oppgave 2.1 -- Hjelpefunksjon

Opprett en tom klasse som heter `Password`.

I denne klassen, opprett en statisk metode som heter `hash(String input)` og som returnerer en `String`-verdi.

Denne statiske metoden skal utføre kodesnutten over, hvor parameteret `input` brukes og hva som returneres er `output`-variabelen.

---

### Oppgave 2.2 -- `void setPassword(String value)`

Denne metoden skal sette verdien i feltet `password` til å være resultatet av `Password.hash(value)` - hvor `value` er parameteret tilgjengelig i metoden `void setPassword(String value)`

#### Oppgave 2.2.1

Test at dette fungerer ved å lage en klasse i en midlertidig klasse (dette er kun for å teste) med en statisk main-metode som printer ut resultatet av følgende kodelinjer:

```java

System.out.println(Password.hash("password")); // XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=

System.out.println(Password.hash("PGR112")); // HRwHBckgE7TRU13p6T6w6yodiip53cJBGSQUiE+dmv4=

System.out.println(Password.hash("Kristiania")); // oC5w6ThGs630uqAJLqJjPAZLGvBM5jFpYYHCLVecNQ0=
```

Sjekk at du får ut riktig resultat ved å sammenligne med kommentarene ovenfor.

---

### Oppgave 2.2 -- `boolean verifyPassword(String value)`

Denne metoden skal sjekke at `Password.hash(value)` er det samme som er lagret i `this.password`-feltet, og returnerer true dersom dette stemmer.

---

### Oppgave 3

Lag en konstruktør i `Account`-klassen som tar inn brukernavn og passord, hvor konstruktøren bruker `setPassword()`-setter-metoden for å sette passordet ved hjelp av `Password.hash(...)`-metoden.

---

> Fortsettelse følger i et annet oppgavesett!