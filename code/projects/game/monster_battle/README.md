# `Monster Battle`

---

Målet med dette programmet er at spilleren kjemper mot en liste med monstre, hvor skaden spiller gjør og skaden monsteret gjør er tilfeldig.

Oppgaven går ut på å implementere ferdig slik at spillet kjører sin gang, og ved å kjøre spillet så vil du få ut en logg over alt som skjedde i løpet av spillet og om spilleren vant eller monsterne vant til slutt.

---

Her anbefales at koden leses igjennom.

Om du ser `TODO` som en kommentar, mangler det kode som må skrives.

Her er en oversikt over klassene som du finner i `src`-mappen:

---

## Main-klassen

Dette er utgangspunktet for å kjøre spillet og inneholder statisk main-metode som kjøres via IntelliJ.

## `Game`-klassen
Inneholder en liste over monstrene (`ArrayList<Monster>`) og den nåværende kampen (`Battle`) som utkjempes.

Her startes også spillet via metoden: `.start()`

## `Battle`-klassen

Inneholder en referanse til spilleren og det nåværende monsteret det kjempes mot.

Når et monster dør, skal det skiftes ut med neste i listen,
hvor spillet går til enten spilleren ikke har mer liv igjen eller det ikke er flere monstre å kjempe mot.

## `Entity`

En abstrakt klasse som beskriver noe som har helsepoeng (*health*), hvor både `Player`- og `Monster`-klassene arver fra denne klassen.

En entitet har liv, minimum skade og maksimum skade lagret som data.

### `Player`

Dette er spilleren som skal kjempe mot monstrene

### `Monster`

Dette er et monster som spilleren skal kjempe mot

### `Boss`

Dette er gjerne det siste monsteret, og er kun unikt om du gjør det unikt.

---

## Hva som skal gjøres:

Når spillet starter, så skal spilleren kjempe mot det aktive monsteret, hvor det går på tur hvem som mister liv.
Spilleren starter først, monsteret etter.
Dette fortsetter til enten:
- Spilleren ikke har mer liv igjen
- Alle monstrene er bekjempet

Det skal printes ut til en enhver tid hva som skjer underveis, hvem som angriper, hvor mye liv som går tapt - alt skal loggføres.

Helt til slutt, så skal det printes ut om spilleren overlevde eller ikke.

---

## Tips:

Sjekk felter, konstruktører og metodene i de ulike klassene for å se etter en sammenheng som kan brukes.

Jobb med en ting om gangen, og begynne gjerne med: `start()`-metoden i `Game`-klassen - her skal spillet startes!


