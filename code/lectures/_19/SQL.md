# SQL-syntaks og eksempler

> Her må du logge inn som `root`
## Opprette ny database

```sql
CREATE DATABASE navn_på_database;
```

## Opprette ny bruker

```sql
CREATE USER 'brukernavn'@'localhost' IDENTIFIED BY 'passord';
```

## Gi tilganger til tabeller i en database til en nylig opprettet bruker

```sql
# database.* står for alle tabeller i en navngitt database
GRANT ALL PRIVILEGES ON navn_på_database.* TO 'brukernavn'@'localhost';
```

## Fjerne bruker

```sql
DROP USER brukernavn;
```

## Oppdatering av tilganger f.eks. etter bruker er fjernet

```sql
FLUSH PRIVILEGES;
```

## Velge aktiv database som spørringer skal kjøres mot

```sql
USE navn_på_database;

```

---

> Eksemplene under tar utgangspunkt i at du har opprettet et brukernavn for et spesifikt project og/eller oppgave,
> og er innlogget som denne i terminalen eller tilsvarende GUI (Workbench/IntelliJ)

---

# Spørringer

I dette emnet bruker vi gjerne følgende type spørringer:

- `CREATE TABLE`
- `SELECT`
- `INSERT INTO`
- `UPDATE`
- `DELETE FROM`

Emnet tar også utgangspunkt i at vi forsøker å få til 3. normalform når vi utformer tabeller som skal representere klasser i Java.
