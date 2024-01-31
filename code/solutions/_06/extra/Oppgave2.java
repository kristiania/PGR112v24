package solutions._06.extra;

import solutions._06.Composer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Oppgave2
{
    public static void main(String[] args) {
        ArrayList<Composer> composers = new ArrayList<>();

        File file = new File("files/tasks/06/composers.txt");

        try {
            Scanner input = new Scanner(file);

            String name;
            int birthYear = 0;
            String delimiter = "---";

            // Dersom filen inneholder en "neste-linje"
            while (input.hasNextLine()) {
                // dukker det opp en feil underveis?
                boolean error = false;

                // så leser vi av linjen som navnet på komponisten
                name = input.nextLine();

                // dersom filen inneholder et heltall
                if (input.hasNextInt()) {
                    // les av heltallet som alderen på komponisten
                    birthYear = input.nextInt();

                    // hopp over linjehopp rett etter tallet (int) vi har lest av
                    input.skip("\n");
                    // MERK: i Windows så må muligens \r\n brukes istedenfor over!
                    // Om du har åpnet en .txt i IntelliJ, om du ser CRLF helt nede til høyre, så må \r\n brukes
                }
                // ellers, alder ikke funnet og filen har en feil
                else {
                    error = true;
                }

                // dersom filen har en "neste-linje"
                if (input.hasNextLine()) {
                    // sammenligner vi neste linje med
                    // teksten som skiller hver komponist
                    if (!input.nextLine().equals(delimiter)) {
                        // om tegnene ikke stemmer, så er det en feil i filen
                        error = true;
                    }
                }

                // dersom en feil oppstod, print ut og avbryt loopen
                if (error) {
                    System.out.println("Feil i filen 'files/composers.txt' funnet!");
                    break;
                }
                // dersom ingen feil, opprett en komponist,
                // og legg til i listen over komponister
                else {
                    composers.add(new Composer(name, birthYear));
                }
            }

            // vi avslutter fil-ressursen vi har jobbet med
            input.close();

            // vi går igjennom hver komponist
            for (Composer composer : composers) {
                // og printer ut informasjon om kompinesten
                // i et format som er kompakt
                System.out.printf(
                        "Composer[name=\"%s\"; birthYear=%d;]%n",
                        composer.getName(), composer.getBirthYear()
                );
            }
        } catch (FileNotFoundException e) {
            System.out.println("Kunne ikke finne 'files/composers.txt'!");
        }
    }
}


