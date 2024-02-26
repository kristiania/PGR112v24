package examples.java.scanner;

import java.util.Scanner;

public class InputFromTerminal
{
    public static void main(String[] args) {
        // Input fra terminalen hentes fra Systen.in
        Scanner input = new Scanner(System.in);

        // Dette er også ikke en ressurs som vi skal lukke via .close()
        // da denne strømmen med data inn til Scanner-en er håndtert
        // av systemet

        //# State Machine
        /*
            Scanner
                Instanser av denne klassen er en tilstandsmaskin,
                som vil si at den bryr seg om en tilstand som
                beskriver oppførsel eller noe spesifikt for hva
                instansen skal gjøre.

                I dette tilfellet: Lese bytes fra en datastrøm.

                Når vi i terminalen skriver noe inn i terminalen,
                er det en konstant strøm med data som kommer inn,
                hvor vi kan ved hjelp av ulike metoder lese av
                ønsket type data.

                Her finner vi for eksempel alle de ulike
                .next*()-metodene

                .nextLine() er veldig mye brukt:
        */

        System.out.println("Skriv inn en linje med tekst:");
        String lineOfText1 = input.nextLine();
        // Her vil tilstandsmaskinen lese fram til den ser:
        // - \n eller \r\n avhengig av systemet som brukes
        // av operativsystemet. Du kan se hvilken type du bruker
        // nede til høyre i vinduet: LF eller CRLF.

        // La oss spørre om alder:
        System.out.println("Hva er alderen din?");
        int age = input.nextInt();

        // Her har tilstandsmaskinen lest det første tallet
        // helt til den finner noe som ikke er et tall, så stopper den

        // Dersom vi skal for eksempel lese av en ny linje med tekst
        // etter dette, trenger vi å håndtere linjehoppet etter
        // tallet vi leste inn.

        // Forsøk å kjøre denne koden uten å fjerne en kommenter under
        // mtp. kodelinjen som tilsvarer hvilket OS du kjører

        // input.skip("\r\n");  // Windows
        // input.skip("\n");    // macOS / Linux

        System.out.println("Skriv inn en linje med tekst:");
        String lineOfText2 = input.nextLine();

        // Hva skjer om du ikke bruker .skip(...) her?
        // Får du skrevet inn noe?

        // ---

        System.out.println("Input:");
        System.out.printf("Age: %d%n", age);
        System.out.printf("Line 1: %s%n", lineOfText1);
        System.out.printf("Line 2: %s%n", lineOfText2);
    }
}
