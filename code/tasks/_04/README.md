# Oppgavesett 04

> Oppgavesettet består av 5 oppgaver og 1 ekstra-oppgave,
> og helt på bunnen informasjon som kan være greit å få med seg.

Tips: `static`-nøkkelordet skal kun brukes dersom dette nevnes spesifikt

---

## Oppgave #1

- Lag en ny klasse som heter `Program`
  - Denne klassen skal kun ha én metode:
    - `runProgram()` med returtypen **void**
  - Metoden skal printe ut "Programmet starter ..." til terminalen

---

## Oppgave #2

- Lag en ny klasse som heter `Computer`
  - Denne klassen skal hun ha en statisk main-metode:
    - Her skal følgende skje:
      - Et objekt (instans) av typen `Program` opprettes
      - Via objektet (instansen) som ble opprettet, kall på `runProgram()`-metoden

---

## Oppgave #3

- Lag en ny klasse som heter `Terminal` med tilhørende konstruktør som initialiserer feltet spesifisert i del-oppgaven under:

  - Denne klassen skal ha følgende felt:
    - `ArrayList<String> options`

  - Denne klassen skal ha følgende metoder:
    - void addOption(String value)
      - Legger til tekst-verdien i ArrayList-en lagret i options feltet
    - void clearOptions()
      - Fjerner alle verdiene lagret i ArrayList-en
    - void displayMenu()
      - Looper igjennom alle valgmulighetene lagret i `options` og viser disse i en nummerert liste i terminalen.
        - Dette gjøres ved hjelp av en for-loop og System.out.println

---

## Oppgave #4
- Lag en ny klasse som heter Word
  - Konstruktøren til denne klasse skal ta imot en String-verdi som er hva ordet faktisk
    er, og lagres i data-feltet spesifisert i del-oppgaven under

- Oppgave 4.1
  - Denne klassen skal ha følgende private-felter:
    - `String data`
      - Inneholder verdien for det faktisk ordet
    - `ArrayList<String> synonyms`
      - Inneholder liste med synonymer tilknyttet ordet

- Oppgave 4.2
  - Denne klassen skal ha følgende public-metoder:
    - `String getWord()`
    - `ArrayList<String> getSynonyms()`

---

## Oppgave #5
- Endre runProgram()-metoden i Program-klassen slik at denne metoden gjør følgende:
  - Oppretter en variabel av type ArrayList<Word> som heter «words»
    - Legg til flere objekter av type Word inn i denne ArrayList-en
    
      Her må du lage dine egne instanser, som vil si at du må lage flere objekter av type Word-klassen ved hjelp av new-nøkkelordet

    - Lag en loop som går igjennom alle Word-objektene i ArrayList-en som inneholder Word-objekter, og print ut følgende:
      - Ordet
      - Tilhørende synonymer
      - Denne kan være litt knotete å få til, da en fort kan ende opp med en loop inne i en loop

      Bruk gjerne følgende kodesnutt for å gå igjennom hvert ord lagret i listen:
 
```
for (Word word : words) {
    // variabelen «word» vil være hvert enkelt ord
}
```

---

## Ekstra-oppgave #1

- Istedenfor en ArrayList<String> for å holde styr på alle synonymer tilknyttet et ord, gjør denne om til å være følgende istedenfor:
  - ArrayList<Word>
  
- Gjør nødvendige endringer andre steder i koden din slik at _alt_ som har med synonymer å gjøre, istedenfor at datatypen String brukes, så skal Word brukes.
- Tilpass runProgram()-metoden i Program-klassen slik at synonymer opprettes og legges til ordene disse er synonymer for.

---

## Informasjon

Bruk følgende link:
- https://www.w3schools.com/java/java_arraylist.asp (For å utforske mer av ArrayList)


Disse oppgavene krever gjerne litt kartlegging av hva som er mulig med ArrayList, hvor det kan være greit å stille seg selv spørsmålene:
- Hvordan legge noe til i listen?
- Hvordan fjerne én spesifik verdi fra listen?
- Hvordan fjerne alt fra listen?
- Og så videre ...

Bruk kodeeksempler og forsøk deg litt fram. Bruk terminalen for å gi deg selv tilbakemeldinger underveis (f.eks. ved å printe ut linjer du bestemmer selv ut til terminalen),