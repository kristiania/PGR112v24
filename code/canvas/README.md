# `code/canvas/`

> Enkel spillmotor som lar deg lage visuelle applikasjoner som tegnes i et vindu med gitt størrelse.

## Komme i gang

La oss starte med å opprette et tomt vindu.

Denne guiden tar utgangspunkt i at du har opprettet en pakke og en klasse i denne pakken.

```java
import canvas.API;
import canvas.Launcher;
import canvas.Plugin;
```

Disse 3 klassene er grunnsteinen i det å komme i gang.

La oss ta en titt på et utgangspunkt for opprette et tomt vindu som er 640x480 stort (piksler):

```java
import canvas.Launcher;
import canvas.Plugin;

class TestWindow extends Plugin {
    public static void main(String[] args) {
        Launcher.createWindow(640, 480, new TestWindow());
    }
}
```

Koden over er det som trengs som et minimum for å opprette et vindu som vises med en bakgrunnsfarge.

La oss utvide dette til å, for eksempel, tegne en firkant!

```java
import canvas.Launcher;
import canvas.Plugin;

class TestWindow extends Plugin {
    public static void main(String[] args) {
        Launcher.createWindow(640, 480, new TestWindow());
    }
    
    public void draw(API canvas) {
        window.drawRectangle(50, 50, 100, 100);
    }
}
```

Måten dette fungerer er at en plugin er kode som kjøres av spillmotoren for å utvide dens funksjonalitet.

Det finnes 3 metoder for å gjøre dette, forutenom `Launcher.createWindow(...)` for å opprette selve vinduet:

```java
void setup(API.Setup window) {
    // kjøres 1 gang før loop-en starter
}

void update(API.Update window) {
    // kjøres 10 ganger i sekundet
}

void draw(API canvas) {
    // kjøres 20 ganger i sekundet
}
```

Hvorfor to ulike metoder som oppdateres flere ganger i sekundet?

`draw(API window)`-metoden er ment for å kun tegne til vinduet, hvor det ikke er meningen å kjøre noe "tung" kode.

`update(API.Update window)`-metoden er hvor du kan ha tyngre utregnelser som f.eks. logikk eller fysikk.

Poenget er at felter brukes for å håndtere data, hvor gjerne `setup(API.Setup window)`-metoden brukes for å sette initialisere nødvendige verdier.
Hvorfor kan ikke dette gjøres i konstruktøren f.eks.? Vinduet er ikke tilgjengelig når konstruktøren kjøres!
Hva om du ønsker å lagre midtpunket i vinduet før du begynner å gjøre utregnelser?

---

Ta gjerne en titt på eksemplene du finner i `code/canvas/examples/` eller `code/canvas/games/`.

Husk, dette er ikke en del av pensum og er for de som ønsker å kunne gjøre noe mer visuelt enn å kun forholde seg til terminalen. 

---

## Koordinatsystemet

Vinduet har 2 akser, en X- og en Y-akse.

X-aksen er negativ venstre og positiv høyre, hvor Y-aksen er negativ opp og positiv ned.

Det øverste punktet til venstre er x0 y0, hvor vi gjerne bruker punkter for å representere disse posisjonene:

```java
import canvas.library.math.geometry.Point;

private Dimension size;

void setup(API.Setup window) {
    this.position = new Point(0, 0);
}

```

Størrelser definereres som en dimensjon;
Dersom vi har et punkt og en størrelse, så kan vi tegne et rektangel slik også:

```java
private Point position;
private Dimension size;

void setup(API.Setup window) {
    this.position = new Point(25, 25);
    this.size = new Dimension(50, 50);
}

void draw(API canvas) {
    window.drawRectangle(this.position, this.size);
}
```

Hva hvis du ønsker å skrive noe tekst midt på skjermen?

```java
private Point center;

void setup(API.Setup window) {
    this.center = window.getCenterPoint();
}

void draw(API canvas) {
    window.drawTextCentered(this.center, "middle of the window");
}
```

---

Det finnes en del metoder, hvor jeg anbefaler å sjekke ut hva IntelliJ foreslår etter du skriver `window.` inne i en av de tre metodene.

---

# Hva en kan forvente

Det er mulig å lage enkle spill eller bruke vinduet for å lage et visuelt brukergrensesnitt for ditt program.

Dette er dog avansert og krever en del av deg med tanke på å være nysgjerrig og det å forsøke seg fram.

Om det er noe du savner eller ønsker implementert, gi meg en lyd!

