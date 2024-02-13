package examples.java.numbers;


// Resource: https://www.w3schools.com/java/java_data_types.asp

public class NumberTypes
{
    private static final String[] types = {
            "byte",
            "short",
            "int",
            "long",

            "float",
            "double"
    };

    public static void main(String[] args) {
        //# Følgende er hele tall, altså tall uten komma og desimaler
        // -128 til 127
        // 1 byte, signert = 7 bit som er brukbare
        byte bits = 0b101_0101;

        // -32,768 til 32,767
        // 2 bytes, signert = 15 bits som er brukbare
        short smallNumber = 32100;

        // -2,147,483,648 til 2,147,483,647
        // 4 bytes, signert = 31 bits som er brukbare
        int number = 123456789;

        // -9,223,372,036,854,775,808 til 9,223,372,036,854,775,807
        // 8 bytes, signert = 63 bits som er brukbare
        long bigNumber= 98765432123456789L;

        // ---
        /*
            Det som er viktig å tenke på med tall-typer, er nå vi konverterer fra en type til en annen.

            På lik linje som vi kan down-caste og up-caste med tanke på polymorfisme, kan vi gjøre det samme her.
            Eneste regelen er at vi kan kun gå fra en mindre type tall til et større tall dersom vi ikke ønsker å miste data.
            Om vi går andre veien, så kan vi potensielt miste data, som er viktig å være obs på.

            Altså: byte -> short -> int -> long; og ved å gå andre veien så mister vi fort data,
            og vi sitter igjen med et tall som egentlig ikke gir mening. Fort for at du også sitten igjen med negativt tall men konverterte et positivt tall.

            Tommelfinger-regel: Kun konverter fra en mindre størrelse til en større en, og ikke andre veien.

           Se eksempel helt på slutten.
        */
        // ---

        //# Flyttall - tall med desimaler etter komma
        // Mister presisjon etter  6 til 7 desimaler
        float floatingNumber = 0.123456F;

        // Mister presisjon etter 15 deismaler
        double doubleFloatingNumber = 0.123456789D;

        // ---
        /*
            Noen type tall trenger at vi er tydelig med hvilken type tall vi snakker om.
            Legg merke til slutten av tallet type long: L på slutten.
            På flyttall har vi F og D på slutten for å tydelig si ifra om hvilket tall vi snakket om.
        */

        // Eksempel på konvertering fra en talltype til en annen
        // IntelliJ vil nevne at dette er redundant, hvor dette er kun for å vise
        // at det er mulig
        byte  A = 1;
        short B = (short) A;
        int   C = (int) B;
        long  D = (long) C;

        long ABC = 98765432123456789L;
        int  CBA = (int) ABC; // = 567,180,565

        float  X = 0.1F;
        double Y = (double) X;

    }
}
