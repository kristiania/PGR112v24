package lectures._23;

import java.util.ArrayList;


public class Forelesning23
{
    public static void main(String[] args) {
        ArrayList<String> topics = new ArrayList<>();

        topics.add(" OOP i et litt annerledes nøtteskal:");
        topics.add("--- Abstraksjon");
        topics.add("----- Eksempel 1: Farm - Animal - Pet");

        topics.add("--- Indre klasser");
        topics.add("----- Eksempel 2: Business - Employee - Customer");

        topics.add("--- Grensesnitt");
        topics.add("----- Eksempel 3: Wardrobe - Clothing - Dresser");

        topics.add(" Sammenhengen mellom database og klasser");

        topics.add(" Hvordan prosjektet som skal leveres mtp. eksamen lages i IntelliJ");

        topics.add(" Spørsmål?");

        topics.add(" Introduksjon til flere større prosjekter");

        topics.add(" Hva siste forelesning vil gå ut på");


        System.out.println("Forelesning 23");

        for (String topic : topics) {
            System.out.print(" -");
            System.out.println(topic);
        }
    }
}
