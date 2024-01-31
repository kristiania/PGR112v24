# Oppgavesett 06

---

Husk: Når du jobber med filer med `Scanner` eller `FileWriter`, husk å bruke .close() når du er
ferdig med koden som leser/skriver filer!

---

## Oppgave #1

- Opprett en tom tekstfil med navn «`numbers.txt`» plassert her: `files/tasks/06/`
  - I denne tekstfilen, skriv inn manuelt 10 ulike heltall, én per linje

- Opprett en klasse som heter `NumbersAddedTogether`
  - Denne klassen skal ha en statisk main-metode som gjør følgende:
    - Oppretter en variabel som heter «`sum`» av typen int som starter med verdien 0

    - Leser tekstfilen «`numbers.txt`» linje-for-linje

    - For hvert tall øk verdien til variabelen «`sum`» slik at denne variabelen representerer summen av alle tallene i tekstfilen

    - Print ut til terminalen summen av alle tallene

# Oppgave #2

- Opprett en klasse som heter `Composer`
  - Klassen skal ha følgende felt:
    - `String` *name*
    - `int` *birthYear*

  - Opprett getter-metoder for disse feltene

  - Klassen skal ha en konstruktør som tar imot navn og fødselsår, for å så lagre denne dataen i feltene nevnt over

  - Opprett en klasse som heter `Oppgave2`
    - Denne klassen skal ha en statisk main-metode som gjør følgende:
    - Oppretter en variabel av typen `ArrayList<Composer>` som heter «`composers`»

  - Les av filen «`files/tasks/06/composers.txt`» linje-for-linje, og:
    - Bruk if-setninger for å vite når et nytt objekt av Composer-klassen skal opprettes

  - For hvert objekt som opprettes, legg objektet til i «`composers`»-variabelen som er en `ArrayList`

  - Etter du har opprettet alle objektene, lagt disse til i «`composers`» og er ferdig med filen, lag en loop som går igjennom hvert `Composer`-objekt lagt til i «`composers`»-listen, og print ut navn og fødselsår per komponist til terminalen

## Oppgave #3

- Opprett en klasse som heter: `AskQuestionsAndSaveAnswers`
  - Denne klassen skal ha en statisk main-metode som gjør følgende: 
    - Oppretter en variabel av typen `ArrayList<String>` som heter «`questions`»

    - Fyller «`questions`» `ArrayList`-en med spørsmål manuelt, gjerne minst 2 til 3 stk

    - Oppretter en variabel av typen `ArrayList<String>` som heter «`answers`»

    - Oppretter en instans av `Scanner` med `System.in` som skal hente inn input fra terminalen

    - Oppretter en instans av `FileWriter` som skal skrive til en fil som heter «`answers.txt`» plassert her: `files/tasks/06/` (Så her må du skrive hele filbanen: `files/tasks/06/answers.txt`)

    - Kjører en loop som går igjennom hvert spørsmål, og for hvert spørsmål:
      - Stiller spørsmål til brukeren via terminalen

      - Bruker Scanner for å hente svaret på spørsmålet, typ. det brukeren skriver inn i terminalen

      - Lagre svaret i «`answers`» `ArrayList-en

    - Etter loopen er ferdig: Lag en ny loop som gå igjennom alle svarene, et svar om gangen, og gjør følgende:
      - For hvert svar, legg til to linjer til tekstfilen «`files/tasks/06/answers.txt`»:
        - Linje 1 = Q: <spørsmålet her>
        - Linje 2 = A: <svaret her>

      - For eksempelvis:
        - Q: Hva heter du?
        - A: Marcus

    - Filen «`files/tasks/06/answers.txt`» skal inneholde en oversikt over alle spørsmålene stilt og tilhørende svar