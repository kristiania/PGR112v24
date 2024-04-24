# Reiseplan

> Reise fra A til B til C, hvor lang tid tar det for eksempelvis totalt?

---

## Oversikt

Dette er et prosjekt som omhandler det å registrere og redigere reiser.

La oss først stadfeste hva en reise er:

- En reise består av en eller flere etapper
- En etappe er en reise fra en lokasjon til en annen med en eller annen form for transport
- En lokasjon er en navngitt adresse



## Praktisk informasjon:

Bruk prosjektet for å trene på det å lage en terminal-meny som lar deg administrere en reise:
- Opprette reiseplan
- Opprette lokasjoner
- Redigere reiseplan for å legge til reiser fra en lokasjon til en annen
- Redigere lokasjoner

Målet er gjerne en lignende flyt:

- Programmet starter
- Om det ikke finnes en reiseplan fra før av, start med å opprette en
  - Eller: Vis en liste over planlagte reiser og la brukeren velge en reise
- Vis informasjon om hele reisen og spør om noe ved reisen skal redigeres
- Når en reise redigeres, så vil du kunne endre hver etappe
- Når en etappe redigeres, så skal du kunne endre starten og slutten av etappen
  - Når start eller slutten av en etappe endres, gjøres dette ved å velge en liste av lokasjoner tilgjengelig eller mulighet for å legge til flere lokasjoner
- Programmet fortsettet helt til brukeren selv velger å avslutte

---

# Del 1 - Planleggingsfasen

Begynn med å planlegge hvordan hele terminalmeny-flyten skal være for brukeren.

Her er det viktig at du ser for deg selv bruke en terminalmeny hvor du skal kunne registere reiser.

---

# Del 2 -  Lag terminalmenyen

Begynn med å lage terminalmenyen, hvor du innledningsvis kun skal håndtere flyten!

Dette vil si at ingenting skal fungere, hvor du kun er ute etter at riktige valg tar deg til relevante metoder.

Hva jeg mener her; La oss bruke følgende terminalmeny som et eksempel:

```
Terminal-meny:

1) Lag ny reiseplan
2) Vis planlagte reiser
3) Rediger reiseplan
4) Avslutt

# Dersom 1) velges:

Skriv inn navnet på reisen: <bruker skriver navnet på reiseplanen>
Hvor starter reisen: <bruker skriver inn hvor reisen starter>
Hvor slutter reisen: <bruker skriver inn hvor reisen slutter>
Hvor lang tid tar reisen: <bruker skriver inn sekunder/minutter>

Reisen har nå følgende antall etapper: 1

Ønsker du å legge til flere etapper? (ja/nei)

...

# Dersom 2) velges:

Antall planalgte reiser 2:

Reiseplan 1: Reise til nærbutikken
Etapper: 3
 - Reise 1: Fra "Hjemme" til "Busstoppet" (Gå, 3 minutter)
 - Reise 2: Fra "Busstopp 1" til "Busstopp 2" (Buss, 10 minutter)
 - Reise 3: Fra "Busstopp 2" til "Nærbutikken" (Gå, 2 minutter)
Reisen tar totalt 15 minutter.

Reiseplan 2: Gå fra rommet til toalettet
Etapper: 1
 - Reise 1: Fra "Rommet" til "Toalettet" (Gå, 15 sekunder)
Reisen tar totalt 15 sekunder

...

Og så videre!

```

En stor del av programmering, spesielt i konteksten av a lage systemer, går ut på å planlegge!

# Del 3 - Implementering

Fullfør et og et valg ut i fra terminalmenyen, til du har noe som fungerer.

Begynn gjerne uten å tenke på databaser for nå, hvor ting kan lagres i felter i de ulike klassene eller filer.

# Del 4 - Databaser

Sørg for at data lagres i databasen, og når hver gang programmet starter, at alle reiseplaner lagret hentes.

En godt tips angående det å ha en database og et objektorientert design, er at en har objekter som kan representere f.eks rader med ulike data fra databasen.

Når noe hentes fra databasen, forsøk å bruk denne dataen for å lage objekter basert på dataen fra databasen.

---

### Forslag til klasser:

- class Main
- class Plan
- class Travel
  - enum Type
- class Location

```java
class Plan {
    String name;
    ArrayList<Travel> travel;
}

class Travel {
    String name;
    Location A;
    Location B;
    int duration;
    
    enum Type {
        Walk,
        Car,
        Bus,
        Train,
        Boat,
        Plane
    }
}

class Location {
    String name;
    String address;
}
```

### Forslag til database-struktur:

> Dette er kun forslag, hvor disse tabellene også kan simplifiseres.
> Forsøk gjerne å finne ut av hva du trenger som et minimum for å lagre nok informasjon (data).

Tips: Still gjerne spørsmål til hvorfor ulike kolonner eller datatyper eksisterer eller brukes!

```sql
CREATE TABLE travel(
  id        INT AUTO_INCREMENT,
  name      VARCHAR(255) UNIQUE,
  note      VARCHAR(255) DEFAULT '',
  PRIMARY KEY (id)
);

CREATE TABLE location(
  id        INT AUTO_INCREMENT,
  name      VARCHAR(255) UNIQUE,
  address   VARCHAR(255) DEFAULT NULL, # kan være tom, kan legges til senere
  note      VARCHAR(255) DEFAULT '',
  PRIMARY KEY (id)
);

CREATE TABLE travel(
  id        INT AUTO_INCREMENT,
  name      VARCHAR(255) NOT NULL,
  a         INT UNSIGNED NOT NULL,
  b         INT UNSIGNED NOT NULL,
  start     BOOLEAN NOT NULL,
  type      ENUM('car', 'bus', 'train', 'boat', 'plane'),
  duration  INT UNSIGNED DEFAULT 0, # sekunder eller minutter, velg en og bruk konsekvent i kodebasen
  note      VARCHAR(255) DEFAULT '',
  PRIMARY KEY (id),
  FOREIGN KEY (a) REFERENCES location(id),
  FOREIGN KEY (b) REFERENCES location(id)
);
```

### Forslag til første valgene i terminalmenyen:

```
<programmet starter>

Velkommen til reiseplanleggeren!

1) Legg til ny reise
2) Liste over alle reiser
3) Liste over alle lokasjoner
4) Legg til ny lokasjon
5) Søk etter reise via søketekst
6) Rediger reise ved å oppgi id-nummer
7) Avslutt

> Valg: 

```