# Løsningsforslag DB_02

> Endelig løsningsforslag som tar for seg DB_01, DB_02, DB_03 og DB_04 samlet sett finner du her: `code/solutions/database/terminal/`

> Koden du finner i dette løsningsforslaget løser kun DB_02 (som baserer seg på DB_01)

---

Oppgave 1 ble gjort ved å opprette klassen `Terminal` med tre felter, hvor 2 er statiske og et av de ikke-statisk.

Oppgave 2 ble gjort ved å logge inn i databasen hvor deretter følgende kommandoer ble kjørt:
- Se fil: `./sql/01_create_database_and_user.sql`

Oppgave 3 ble gjort ved å endre `files/tasks/database/_02/database.properties`, med den viten at faktisk løsning skal gjøres her egentlig: `files/tasks/database/terminal/database.properties`; 
Denne endringen finner du i løsningsforslaget du finner helhetlig sett her: `code/tasks/database/terminal/`

Oppgave 4 ble gjort ved å legge til en statisk kodeblokk rett under de statiske feltene, hvor følgende ble gjort:
- Registrering av driver og innlasting av verdier fra `database.properties`-fil:

```java
static {
    try {
        DriverManager.registerDriver(new Driver());

        Terminal.configuration.load(new FileInputStream("files/tasks/database/terminal/database.properties"));
    } catch (SQLException | IOException e) {
        throw new RuntimeException(e);
    }
}
```

`RuntimeException` kastes dersom noe galt skjer ved registering av driver (`SQLException`) eller innlastingen av verdiene fra `database.properties` (`IOException`)

Oppgave 5 ble gjort ved å opprette en `getDatabaseConnection()`-metode som returnerer en `Connection`, og ble løst slikt med tanke på kode:

```java
static Connection getDatabaseConnection() throws Exception {
    String host = Terminal.configuration.getProperty("host");
    String port = Terminal.configuration.getProperty("port");
    String database = Terminal.configuration.getProperty("database");
    String username = Terminal.configuration.getProperty("username");
    String password = Terminal.configuration.getProperty("password");
        
    // URI: jdbc:mysql://host:port/database
    return DriverManager.getConnection(STR."jdbc:mysql://\{host}:\{port}/\{database}", username, password);
}
```

Her velges `throws Exception` da det kan oppstå to helt ulike exceptions:
1. `IOException`: Dersom det å hente verdi fra `this.properties` feiler, altså, relevant data ble ikke lastet inn fra `database.properties`
2. `SQLException`: Dersom det oppstår en feil med å hente tilkobling til databasen

Dette er typ polymorfisme da en vagere type brukes (upcasting) for å ta nytte av at alle exceptions stammer fra `Exception`-klassen via arv

