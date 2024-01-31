# Oppgavesett 08

---

Oppgavene kan løses i `./src/`-mappen som du ser over denne `README.md`-filen

Om du ønsker å versjonskontrollere koden din, kan de anbefales at du laget et eget project i IntelliJ og kopierer over innholdet fra `./src/`-mappen her over i det nye prosjektet.

---

Dette oppgavesettet går ut på å lage ulike figurer som er geometriske: Sirkler, kvadrater, rektangler, osv.

Målet er at vi i et senere oppgavesett vil tegne disse grafisk ut i et eget program-vindu hvor vi vil se disse figurene visuelt, hvor dette oppgavesettet går ut på å klargjøre disse klassene for slik bruk senere. Dette vil si at objektene som opprettes som isntanser har dataene og metodene disse figurene trenger for å tegnes senere.

I kodeutgangspunktet for oppgavestter, finner vi 3 klasser:
- Shape
- Circle
- Square
- 
Begynn med å lese deg igjennom disse klassene og bli kjent med hvordan disse er bygget opp som klasser (felter, metoder, konstruktører) før du fortsetter.

I klassene hentet ut fra .ZIP-filen, arver både Circle og Square fra klassen Shape.
I forelesningen har vi hatt om abstrakte klasser, og en del av oppgavene går ut på å ta i bruk nøkkelordet abstract og tilpasse koden i de ulike klassene deretter.
Akkurat nå er det mulig å opprette instanser (objekter) av klassen Shape, noe som kan virke lite hensiktsmessig, fordi vi har jo klasse som representerer faktiske figurer.
Ved å opprette Shape-objekter, så vil ikke disse objektene kunne representere spesifikke geometriske figurer, da klassen i seg selv er laget for å representere figurer på en generisk måte.

---

## Oppgave #1
- Sørg for at vi ikke kan opprette objekter av type Shape

## Oppgave #2
Vi ønsker oss at alle ulike subklasser av klassen Shape (klasser som arver fra Shape) tilbyr følgende metoder:
- En metode som regner ut og returnerer arealet til figuren
- En metode som regner ut og returnerer omkretsen til figuren

Hint: Metoder kan være abstrakte!

Gjør nødvendige endringer for å få dette til


## Oppgave #3
- Opprett en Rectangle-klasse, som har følgende felt for å holde på data om det geometriske tilknyttet figuren:
  - double width
  - double height

Sørg for at denne klassen implementerer metodene fra oppgave #2!


## Oppgave #4
- Gjør om Square-klassen slik at denne arver fra Rectangle-klassen istedenfor Shape-klassen

Fjern overflødige felter og metoder, da disse vil kunne arves direkte fra Rectangle-klassen istedenfor! Sjekk gjerne om IntelliJ rapporterer om dette i form av tilbakemeldinger eller feilmeldinger, og utfør nødvendige endringer deretter.


## Oppgave #5
- Sørg for at alle figurer har et id-felt av datatypen int som ikke kan endres etter den er satt

- Lag en getter-metode for å hente ut denne identifikator-verdien

Hint: Et statisk felt i en klasse som alle figurene forholder seg til kan brukes for å holde styringen på neste id-nummer, som gjerne kan settes via en konstruktør i en klasse som er til felles for alle figurene


## Oppgave #6
- I alle sub-klassene (av Shape), opprett en toString()-metode for å kontrollere hvordan informasjonen om objektet printes ut til terminalen dersom det forsøkes å printe ut referansen til objektet direkte til terminalen

Legg til @Override-annotasjonen rett ovenfor disse metodene for å gi et hint til kompilatoren at vi overskriver denne metoden, toString()-metoden er en metode som arves fra Object-klassen, som alle klasser i Java arver fra originalt uten at det eksplisitt står i koden vår at alle klasser arver fra Object-klassen


## Oppgave #7
- Opprett en ny klasse som heter JavaProgram
  - Denne klassen skal ha en statisk main-metode som gjør følgende:
  - Oppretter 10 objekter av forskjellige typer geometriske figurer
  - Plasserer disse objektene i et HashMap hvor:
  - id-verdien fungerer som en nøkkel
  - Shape-klassen som en datatype for verdiene

---

Oppgave #8 og #9 gjøres i main-metoden opprettet i oppgave #7

---

## Oppgave #8
- Gå igjennom alle objektene (figurene) i HashMap-et opprettet og skriv ut informasjon om hvert objekt til terminalen (slik at toString()-metoden brukes uten at en må kalle direkte på toString-metoden)


## Oppgave #9
- Velg ut et objekt fra HashMap-et basert på en nøkkel du vet eksisterer og sjekk om du fikk forventet objekt ved å skrive ut informasjon om objektet

---

## Ekstra utfordringer
- a) Det finnes flere ulike måter å gå igjennom alle elementene i et HashMap på, ta gjerne en titt på lenken du finner nederst i dette tekstdokumentet

Forsøk de ulike metodene mtp. oppgave #8 og se om du finner en måte å gjøre det på som du foretrekker


- b) Skriv ut informasjon om alle figurer som har et areal som er større en viss grense som settes via en variabel, hvor dette gjerne kan gjøres i bunnen av main-metoden opprettet i oppgave #7

---

Hvor du kan lese mer om HashMap:
- https://www.w3schools.com/java/java_hashmap.asp