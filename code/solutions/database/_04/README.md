# Løsningsforslag DB_04

> Endelig løsningsforslag som tar for seg DB_01, DB_02, DB_03 og DB_04 samlet sett finner du her: `code/solutions/database/terminal/`

> Koden du finner i dette løsningsforslaget løser kun DB_04 (som baserer seg på DB_01, DB_02 og DB_03)

---

Oppgaven ble løst ved å gjøre 3 endringer i `Terminal`-klassen.

Disse 2 endringene befinner seg i tre ulike metoder:
- `userExists(String username)` (Linjenummer 57-68)
- `createUser(String username, String password)` (Linjenummer 81-86)
- `login(String username, String password)` (Linjenummer 112-122)

Tidligere (og usikker!) løsning er kommentert ut, hvor riktig (og sikker!) kode er nedenfor kommentarene.
