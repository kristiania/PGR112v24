# Hotell

> Dette er et prosjekt som er åpent og abstrakt, som kan bli stor, hvor kjennskap til hvordan det er å være hotell-gjest eller hva et hotell består av (resepsjon, etasjer, rom, osv.) kan hjelpe.

Oppgaven består av flere deler hvor hver del har oppgaver tilknyttet delen.

Ta gjerne notater underveis, gjerne tilknyttet hver del og tilhørende oppgave.

---

Del 1 baserer seg på å få kodet det en trenger av klasser og hvordan disse henger sammen.

Del 2 baserer seg på det å ta i bruk en database for å lagre mye av informasjonen fra klassene.

---

Oppgaven kan gjerne gjøres ved å opprette en `src`-mappe ved siden av denne `README.md`-filen, typ. her:
- `code/projects/travel/hotel/src`

---

## Del 1: Hva er et hotell?

> Hvor skal man begynne?

Hvis noen spurte deg: "Kunne du forklart meg hva et hotell er?" - hvor hadde du begynt?

Hva et rom er?
At det finnes en resepsjon?
At hoteller vanligvis har en heis?
At det er flere rom per etasje som enkeltvis kan leies?
At det ofte finnes en restaurant eller bar i samme etasje som resepsjonen?

Spørsmålene kan ofte ende opp med å være endeløse med mindre en begrenser seg selv eller prosjektet en arbeider med.

I denne del-oppgaven, så skal du finne et utgangspunkt du kan ta for å kartlegge det å kode et enkelt hotell.

Først og fremst, velg en av følgende tre valg:

1) Jeg ønsker å ta utgangspunkt i selve hotellrommet, bli ferdig med det før jeg jobber meg utover med etasjer for å deretter representere hotellet ved å si at hotellet består av X antall etasjer, og hver etasje inneholder forskjellige fasiliteter, som f.eks. rom, resepsjon, trapp, inngang/utgang, osv.

2) Jeg ønsker å ta utgangspunkt i reisen som en hotell-gjest, hvor jeg starter med resepsjonen og det å sjekke inn på et rom, for å så jobbe fra resepsjonen og hele veien til hotellrommet, ved å representere det som trengs på veien til gjesten har sjekket inn til de er inne på hotell-rommet.

3) Jeg ønsker å ta utgangspunkt i etasjene og legge til rette for mulige ulike type rom, og sette sammen hotellet med utgangspunkt i hvordan det er strukturert gjennom etasjene.

I bunn og grunn handler valgene om hvor du starter: hotellrommet, resepsjonen eller etasjene?

PS: Om du trenger forslag til klasser, finner du forslag nederst i tekst-dokumentet.

Ut i fra valget tatt, gjør følgende del-oppgave til å begynne med;
Når du har gjort deg ferdig så kan du gjerne gå til relevant del-oppgave ut i fra hva du holder på å lage av klasser.


### Del 1 - Utgangspunkt 1 - Hotellrommet

Ta utgangspunkt i å representere selve hotellrommet.

Begynn med en klasse som heter `Room`, og begynn med følgende spørsmål: "Er alle rom like eller har hotellet ulike type rom?"

Svaret på spørsmålet indikerer gjerne om `Room`-klassen burde være abstrakt eller ikke.

Dersom du ender opp med å ønske ulike type rom og at denne klassen nå er abstrakt, opprett relevante klasser for de ulike type rommene, som f.eks.:
- CompactRoom
- DoubleBedRoom
- Penthouse
- Suite

Og så videre.

Deretter begynn med klasser for hva du ønsker skal være en del av rommet: Seng? Kjøleskap? Klesskap? Bad?

Det er ikke snakk om her å kode disse klassene fult ut, men gjerne det å kunne ha disse klassene som et utgangspunkt for abstraksjoner;
Hva inneholder rommet? Inneholder rommet flere rom? Er sofaen en ekstra gjesteseng?

Alt dette kan representeres via tomme klasser for nå, hvor det viktigste er hvordan disse er lagret opp mot `Room`-klassen (evt. sub-klassene dersom denne klassen er abstrakt).

Se gjerne forslag til klasser i bunnen av tekst-dokumentet, og husk, fokuset er struktur og hvordan alt skal henge sammen. Det å kode implementasjonene (metoder) foruten for dataen som trengs for å representere objektene av disse klassene, kan gjøres senere ved behov/ønske.

For eksempel, om du lager en TV, kan du gjøre det enkelt ved å si at TV-en er av eller på. Klesskap, tatt i bruk eller ikke? Sovesofa, gjort om til gjesteseng eller ikke?

Hold det enkelt for nå, du har potensielt et helt hotell du skal bygge sammen ved hjelp av klasser!


### Del 1 - Utgangspunkt 2 - Resepsjonen

Begynn med resepsjonen, og det å få sjekket inn en gjest og tillegne gjesten eller gjestene et rom.

Begynn med en `Guest`-klasse og en `Reception`-klasse, og lag funksjonalitet for kommunikasjonen (metoder som gjør noe data!) som trengs mellom en gjest og en resepsjon for å booke et rom.

Ikke tenk på databasen for nå, hvor du evt. kan ta en titt på forslag til SQL-struktur nederst i tekst-dokumentet.

Målet her er ikke å lage f.eks. en terminal-meny, men å legge til rette for at vi har metodene som trengs i hver klasse for å kunne utføre de ulike handlingene, som f.eks. registrere gjest, sjekke inn gjest, sjekke ut av rommet, osv.

Når du er ferdig med innsjekk og tildeling av rom til gjest(ene), ta tak i behovet for at rommet gjerne er i en spesifik etasje, og hva som da trengs for å representere rommet; Hvilken etasje er rommet i? Hv

### Del 1 - Utgangspunkt 3 - Etasjene
 
Begynn med en `Floor`-klasse og legg til rette for hva som finnes i en etasje, hvor det ofte er forskjell på første etasje og andre etasjer.

En egen klasse kan for eksempelvis opprettes for `FirstFloor` som arver fra `Floor`, hvor resepsjonen og f.eks. heiser kan legges til her, hvor `Floor` gjerne kan inneholder rom, hvor også første etasjen kan gjøre dette med evt. ekstra funksjonalitet som for eksempel resepsjonen.

Når du har fått en god struktur for hvordan ulike etasjer kan representeres, opprett en `Hotel`-klasse hvor alle etasjene er samlet i et felt som kan gi mening, f.eks. `HashMap<Integer, Floor>` eller noe som du føler passer for å holde styr på etasjer.

Når du er ferdig med dette, fortsett med hotellrom eller det å få laget en resepsjon, sjekk gjerne de andre utgangspunktene for akkurat dette.

---

> Del 2 - Hvordan lagre informasjonen i databasen?

## Fortsettelse følger, del 2 legges ut etter forlesning 24

---

> Informasjon og forslag:

## Praktisk informasjon

Ikke tenk så mye på hva metoder skal inneholde! Sørg for at de har navn som gir mening og riktig retur-type, så kan en komme langt med tanke på å planlegge kodebasen sin og et større system.

## Forslag til klasser (OBS: Dette er kun forslag for å gi deg en idé om klasser som kan brukes!):

- class Hotel
- class Guest extends Person
- class Reception
- class Floor
- (abstract) class Room
  - (inner) class Facility
    - For eksempelvis om et rom inneholder TV, eget bad, sofa, hårføner, lenestol, klesskap osv. eller ikke
- class Restaurant
- class Bar
- interface Shop
  - Kan for eksempelvis brukes for å forklare funksjonalitet som salg av varer/tjenester, f.eks. resepsjonen, restaurant, bar, suvernirbutikk osv.
- class Elevator
- class Staircase
- class Entrance
- class Exit

## Forslag til SQL-struktur:

```sql
CREATE TABLE hotel(
    id          INT AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL DEFAULT 'Hotell',
    email       VARCHAR(255) UNIQUE,
    address     VARCHAR(255) NOT NULL,
    rooms       INT UNSIGNED NOT NULL,
    floors      INT UNSIGNED NOT NULL DEFAULT 1,
    reception   BOOLEAN NOT NULL DEFAULT TRUE,
    
    PRIMARY KEY (id)
);

CREATE TABLE guest(
    id          INT AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL DEFAULT 'Anonym',
    email       VARCHAR(255) UNIQUE,
    age         INT UNSIGNED NOT NULL,
    
    PRIMARY KEY (id)
);

CREATE TABLE room(
    id          INT AUTO_INCREMENT,
    number      INT UNSIGNED UNIQUE,
    
    PRIMARY KEY (id)
);

CREATE TABLE room_facility(
    id          INT AUTO_INCREMENT,
    room        INT UNSIGNED,
    facility    ENUM('bathroom', 'balcony', 'fridge', 'wardrobe', 'room-service', 'tv', 'chromecast', 'speaker', 'couch', 'table'),
    state       BOOLEAN,
    
    CONSTRAINT facility_status PRIMARY KEY (room, facility),
    FOREIGN KEY (room) REFERENCES room(id)
);

CREATE TABLE check_in(
    id          INT AUTO_INCREMENT,
    room        INT NOT NULL,
    guest       INT NOT NULL,
    date        VARCHAR(255) NOT NULL,
    
    PRIMARY KEY (id),
    FOREIGN KEY (room) REFERENCES room(id),
    FOREIGN KEY (guest) REFERENCES guest(id)
);
```
