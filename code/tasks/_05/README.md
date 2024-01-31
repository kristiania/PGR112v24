# Oppgavesett 05

Oppgavesettet består av 3 oppgave og 2 ekstra oppgaver, og helt på bunnen annen informasjon som kan være greit å få med seg.


Tips: «`static`» nøkkelordet skal kun brukes dersom dette nevnes spesifikt!


Tips: Bruken av ordet «bruker» refererer til den som kjører programmet, for eksempel brukeren som kjører Java-programmet og da kanskje ender opp i en situasjon hvor de må skrive inn noe som input i terminalen.

---

## Oppgave #1
- Lag en ny klasse som heter `TerminalPassword`
  - Denne klassen skal kun ha statisk main-metode som gjør følgende:
  - Lagrer korrekt passord i en String variabel
  - Oppretter en ny `Scanner` ved bruk av `System.in`
  - Bruker Scanner-instansen for å spørre om et passord fra brukeren
  - Sammenlign passordet brukeren skriver inn med det korrekte passorder, og print ut til terminalen om passordet skrevet inn var riktig eller ikke 


## Oppgave #2
- Lag en ny klasse som heter `Questions`
- Denne klassen skal ha en statisk main-metode som gjør følgende:
  - Oppretter et tomt `ArrayList<String>`-objekt som heter questions
  - Lager flere spørsmål ved å legge disse til i `ArrayList`-en
  - Oppretter et tomt `ArrayList<String>`-objekt som heter answers
  - Oppretter en instanse av `Scanner`-klassen ved bruk av `System.in`
  - Lag en loop som går igjennom hvert spørsmål, og:
    - Printer ut spørsmålet
    - Henter inn hva brukeren skriver inn som svar på spørsmålet
    - Lagre dette i answers `ArrayList`-en
    - Etter loopen har kjørt, print ut hvert spørsmål med tilhørende svar på spørsmålet


## Oppgave #3
- Lag en ny klasse som heter `InteractiveTerminal`
  - Denne klassen har kun en statisk main-metode som gjør følgende:
    - Printer ut en meny med 3 valg presentert som en nummerert list, gjerne ved hjelp av en loop
    - Ber brukeren velge et av numrene som representerer et valg i menyen
    - Printer ut hvilket menyvalg brukeren valgte

---

## Ekstra-oppgave #1
- Kombinasjon av oppgave #1 og oppgave #3:
  - Før brukeren blir presentert med en meny med nummererte valg, må brukeren først skrive inn et riktig passord
  - Etter at riktig passord er skrevet inn, vis menyen og la brukeren velge et menyvalg og print ut til terminalen brukerens menyvalg
  - Dersom passordet er feil, spør om passord på nytt


## Ekstra-oppgave #2
- Gjør oppgave #3 med følgende kodesnutt som sjekker hvilket menyvalg brukeren gjorde:

```java
switch (menuChoice) {
  case 1 -> System.out.println(“Brukeren tastet inn 1!”);
  case 2 -> System.out.println(“Brukeren tastet inn 2!”);
  case 3 -> System.out.println(“Brukeren tastet inn 3!”);
}
```

Kodesnutten over limes inn rett etter du har hentet inn hva brukeren ga som input via terminalen etter en meny med 3 valg ble presentert.

Her legges det til grunn at valget brukeren skriver inn er et heltall lagret i en variabel som heter `menuChoice` med datatypen *int*

