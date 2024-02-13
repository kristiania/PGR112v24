# `Text Adventure`

Det første du gjør, er å kjøre den statiske main-metoden i klassen som heter "**Main**".

Spillet går ut på at du kan skrive inn kommandoer.

Skriv inn `help` for å få opp en liste med tilgjengelige kommandoer.

Her anbefales det at terminalen som dukker opp i IntelliJ, at høyden på terminalen økes slik at du ser alt som printes ut!

---

## Liste over tilgjengelige kommandoer

- help
- exit
- go up
- go down
- go left
- go right
- enter house

---

Det første som printes ut er kartet som viser 2 ting:
- Hvor spilleren er
- Hvor et hus er lokalisert

Huset har en kodelås som må skrives inn for å kunne gå inn i huset - og som for nå er måten å vinne spillet på.

---

Ser du `> ` i terminalen så betyr det at en kommando kan skrives inn.

Bruk først tid på å utforske hva du kan gjøre i spillet slik det er nå med koden tilgjengelig som et utgangspunkt.

---

## Hva du skal gjøre:

For å finne koden til døren for å komme deg inn i huset, trenger du å finne en bok (`Book`-klassen),
men akkurat nå er ikke boken lagt til i spillet.

Uten denne koden må du være heldig eller gjette et tall opp til over 9000 ganger.

> Utforsk hvordan huset (`House`-klassen) legges til i spillet

Legg til boken i spillet og lag en kommando som heter `open book` -
som da vil åpne boken og printe koden til døren.

Spilleren må være i nærheten av huset eller boken for å kunne bruke kommandoer relevant for disse.

Eksempler på hvordan legge til kommandoer finner du i `Game`-, `Player`- og `House`-klassen.

I konstruktøren til `Book`-klassen lagres koden i et felt, og det er dette feltet du leser av når spilleren åpner boken.

---

# Tips:

Bruk tid på å utforske spillet og hvordan det fungerer før du starter!

Utforsk hva du kan gjøre med kommandoene som allerede eksisterer og forsøk å identifiser relevant kode for hva du møter på og som skjer underveis.

Du står fritt til å gjøre de endringer du måtte ønske, f.eks. hvor spilleren starter eller hvor huset befinner seg.

Gjør endringer for å se hva som skjer!

Det kan anbefales at det taes en kopi av kodeutgangspunktet, hvor du uansett finner utgangspunktet via GitHub om du skulle ønske å gå tilbake til koden slik den var før du selv gjorde endringer.

---
