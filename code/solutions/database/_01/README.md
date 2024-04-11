# Løsningsforslag DB_01

> Endelig løsningsforslag som tar for seg DB_01, DB_02, DB_03 og DB_04 samlet sett finner du her: `code/solutions/database/terminal/`

> Koden du finner i dette løsningsforslaget løser kun DB_01

---

Oppgave 1 ble løst ved å opprettet en klasse med 2 felter og en getter-metode for å hente ut brukernavnet.

PS! Oppgavesettets rekkefølge på oppgavene ble ryddet opp i forbindelse med dette løsningsforslaget, spesielt med tanke på oppgave 2.

Oppgave 2 i seg selv fører til løsningen for oppgave 2.1, da testingen av koden i oppgave 2 går ut på å utforske at ved å endre `input`-variabelen
så vil en få printet ut til terminalen en lengre rekke med tilfeldige tall og bokstaver som forblir det samme dersom `input` ikke endrer seg.

Oppgave 2.1 ble gjort ved å ha `String input` som parameter og deretter returnere direkte resultatet av `Base64.getEncoder().encodeToString(...)`

Oppgave 2.1.1 ble gjort ved å opprette klassen `TestPasswordHash` hvor koden fra oppgave eksempelet ble limt inn i en statisk main-metode i denne klassen og deretter kjørt,
hvor resultatet av hva som ble printet ut til terminalen ble sammenlignet med kommentarene for å sjekke om det er riktig.

Oppgave 2.2 tar oss tilbake til `Account`-klassen hvor det opprettes en setter-metode for `password`-feltet, hvor verdien som lagres i feltet kjøres igjennom `Password.hash(...)`-metoden først.

Oppgave 2.3 innebærer å opprette en metode som heter `verifyPassword(...)` som tar å sammenligner passordet som kommer inn som klartekst (hva det faktiske passordet er),
kjører det igjennom `Password.hash(...)`, for å så sammenligne med feltet `password` og derigjen returnerer resultatet av sammenligningen.

Oppgave 3 ble gjort ved å opprette en konstruktør i `Account`-klassen som da setter `username`-feltet direkte og deretter `password`-feltet indirekte ved å kalle på setter-metoden som da setter passordet ved hjelp av `Password.hash(...)`