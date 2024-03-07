package lectures._16.sandbox.B;

import lectures._16.sandbox.A.KlasseA;

public class KlasseC
{
    public static void main(String[] args) {
        KlasseB classB = new KlasseB();
        KlasseA classA = new KlasseA();

        classB.method();
        classA.method();

        KlasseA.printInfo();
        KlasseA.printInfo();

        KlasseC.turnStringIntoBigLettersIfLengthy(
                ""
        );
    }

    public static String turnStringIntoBigLettersIfLengthy(String text) {
        if (text.length() > 128) {
            return text.toUpperCase();
        }
        else {
            return text;
        }
    }
}
