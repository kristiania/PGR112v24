# Oppgavesett 07

## Oppgave #0

Lag en liste med minst 3 ulike klasser som du kunne tenkt deg å lage, hvor disse klassene  skal representere noe enkelt som kan «objektiviseres», med dette så menes det for eksempel:
- Lyspære (LightBulb)
- Pizza
- Lommebok (Wallet)
- Bok (Book)
- Batteri (Battery)
- Brusboks (SodaCan)
- Musikkspiller (MusicPlayer)
- Bankkonto (BankAccount)


Målet er rett og slett å finne noe som du ønsker å kode, og som er henholdsvis enkelt å definere ved hjelp av felter og metoder. I .ZIP-filen som kan lastes ned så kan du sjekke ut «eksempel»-mappen for å se eksempler på hva jeg mener.


Det som menes med «enkelt» er at det er forståelig og ikke-komplisert. Du ønsker noe som har identifiserbare kjennetegn (farge, navn, tittel, antall, osv.).


Klasser i Java fungerer som en mal for hvordan et objekt skal opprettes. Objekter i Java har felter (hvor data lagres), metoder (hva kan objektet gjøre?) og en (eller flere) konstruktører (hva som må gjøres for å klargjøre objektet som skal opprettes basert på klassen).


Eksempler på felter du kan benytte deg av, hvilken type som skal brukes (String, int, double, boolean, ArrayList, en annen klasse osv.) per felt er opp til deg:
- color
- size
- weight
- width
- height
- temperature
- humidity
- quantity
- isOpen
- isClosed
- isCold
- isUnique
- isFragile

Og så videre; Dette er bare eksempler, kom gjerne på egne forslag til felter så lenge det gir mening for objektet du ønsker å ende opp med. Ikke lås deg til at det er disse feltene du må bruke, det er du som programmerer som har kontrollen over din egen kode og hvordan du går fram for å løse problemet: hvordan representere et objekt?

Et tips her er gjerne å huske tilbake til database-emnet og hvordan en setter opp tabeller for å representere data i en database.

For å bruke en form for metafor:

> Database-kolonnene er feltene i klassen og hver database-rad er et objekt.


Metoder kan for eksempelvis være getter- og setter-metoder, og ellers annen funksjonalitet som er relevant for objekter som opprettes. For eksempelvis, en dør trenger fjerne metoder for å både lukke og åpne døren, en vannflaske trenger gjerne metoder for å drikke (minske volumet) eller for å fylle på (øke volumet), og så videre...

Dette kan være utfordrende, men er en god utfordring for å trene på abstraksjon og identifisere relevant informasjon som representerer et objekt godt nok.

Lykke til! Oppgavene fortsetter under, og tar utgangspunkt i at du har laget deg en liste med minst 3 klasser du ønsker å opprette, og har planlagt hvilke felter og metoder denne klassen trenger.

---

## Oppgave #1

- For hver av klassene du har planlagt:
  - Lag klassen med et engelsk navn, og:
    - Opprett felter
    - Opprett konstruktør(er)
    - Opprett getter- og nødvendige setter-metoder
    - Opprett andre metoder relevant for hva objektet kan gjøre (endre data, printe ut informasjon om seg selv, gjøre et regnestykke basert på data lagret i objektet, osv.)


- Opprett en klasse som heter «JavaProgram1»
  - Denne klassen skal ha en statisk main-metode som tar i bruk klassene du opprettet over
  - Her kan du for eksempelvis lage et fiktivt scenario eller se for deg at du kjører en form for simulering hvor disse klassene brukes for å lage objekter som er en del simuleringen, og disse objektene er aktørene som gjør noe


## Oppgave #2

- 1) Planlegg og opprett en klasse som andre klasser kan basere seg på ved hjelp av arv (inheritance). Sjekk gjerne slides eller opptaket for forelesningen for å få en bedre forståelse av hva som menes med dette

- 2) Etter du har opprettet denne klassen, opprett 2 nye klasser som arver fra klassen du har laget

- 3) Opprett en ny klasse som heter «JavaProgram2»
      - I denne klassen, opprett en statisk main-metode som tar i bruk klassene som arver fra klassen du laget innledningsvis, og som tar i bruk metoder for å gjøre noe med denne klassen


## Oppgave #3

- Velg en av klassene du lagde i oppgave #1, og gjør denne om til en klasse som andre klasser kan arve fra. Dette kan gjøres i en ny klasse med et litt annerledes navn eller ved å legge på «Generic» foran navnet på klassen

- Opprett en ny klasse som arver fra denne nye klassen, og test ut at alt fungerer som det skal (at du har tilgang til metoder og data (via getter-metoder)

---

## Ekstra utfordring - `aggregering`

