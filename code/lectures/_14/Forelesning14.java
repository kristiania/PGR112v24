package lectures._14;

import java.util.ArrayList;

public class Forelesning14
{
    public static void main(String[] args) {
        String[][] SOLID = {
                {
                    "Single Responsibility",
                        "Klassen har ansvar for én ting - mindre ansvar fører til mindre kompleksitet.",
                        "Mindre kompleksitet = lettere å teste = lettere å vedlikeholde",
                        "Jo mindre ansvar en klasse har, jo lettere  å er det gjenbruke hva klassen representerer, " +
                                "istedenfor at vi må ta hensyn til ansvar som gjerne ikke er relevant i alle situasjoner."
                },
                {
                    "Open/Closed",
                        "Open for extensions, closed for modifications",
                        "Åpen for utvidelser, stengt for endringer",
                        "Dette vil si at når en klasse er ferdig og gjør det den skal, så kan vi heller utvide klassen " +
                                "dersom vi ønsker å legge til mer funksjonalitet.",
                        "Dette gjør koden vår mer robust ved endringer i senere tid, ved at vi introduserer utvidelser " +
                                "til koden vår istedenfor å gjøre endringer i kode som fungerer og gjør som den skal.",
                        "Bruk gjerne `extends`-nøkkelordet her, ved at vi lager klasser som følger prinsippet at vi " +
                                "lager en ny klasse som fortsatt ER den klassen vi utvider.",
                },
                {
                    "Liskov substitution",
                        "Dersom en klasse Y er en subklasse av klasse X, så skal vi kunne endre bruken av en instans av klassen X " +
                                "i koden vår med en instans av klassen Y uten at dette medfører problemer i koden vår.",
                        "Dette vil si at i tilfeller vi jobber med en generell type klasse (f.eks. Animal, Vehicle, Component, osv.) " +
                                "så skal vi kunne bruke en hvilken som helst sub-klasse. Dette henger sammen med at arv fører til en sterk" +
                                "relasjon mellom klassene ved et ER-forhold, at vi kan si at en klasse ER en annen klasse.",
                        "Dette gjelder spesielt bruker av abstrakte klasse som en datatype, at vi skal kunne bruke alle sub-klasser når data-typen " +
                                "vi jobber med er generell av natur.",
                },
                {
                    "Interface Segergation",
                        "Ved å bryte opp et grensesnitt som består av flere metoder opp i flere grensesnitt, lar dette oss " +
                                "bruke disse mindre grensesnittene på en mer fleksibel måte.",
                        "Klasser kan implementere uendelig med grensesnitt, og grensesnitt kan utvides av andre grensesnitt.",
                        "Store grensesnitt kan være mindre fleksibelt å jobbe med, spesielt når vi i tilfeller ikke behøver hele grensesnittet.",
                        "Mindre grensesnitt kan føre til mer modulær kode ved at vi istednefor et stort grensesnitt heller setter " +
                                "sammen flere grensesnitt for å finjustere akkurat det vi ønsker at en klasse skal levere totalt sett av et grensesnitt.",
                        "Disse mindre grensesnittene kan for eksempel brukes for å spesifiere èn type oppførsel, f.eks. om noe kan gå, svømme eller fly.",
                },
                {
                    "Dependency Inversion",
                        "Klasser kan settes opp ved at instanser av en klasse inneholder flere instanser av en annen klasse lagret via feltene til klassen.",
                        "Istedenfor å opprette nye klasser f.ek.s i konstruktøren til en klasse, kan det være gunstig å la disse instansene " +
                                "istedenfor være argumenter til konstruktøren, da dette gir oss mer kontroll med tanke på å tilpasse de interne instansene " +
                                "som sammen utgjør en klasse ved at vi oppgir disse når klassen opprettes, istedenfor at klassen selv står for " +
                                "opprette disse instansene internt.",
                }
        };

        for (String[] letter : SOLID) {
            System.out.print("--- ");
            System.out.println(letter[0].charAt(0));

            System.out.print(letter[0]);
            System.out.println(":");

            for (int i = 1; i < letter.length; i ++) {
                System.out.print(" - ");
                System.out.println(letter[i]);
            }
        }

    }
}
