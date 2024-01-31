package solutions._05;

import java.util.Scanner;


// Oppgave #1
public class TerminalPassword
{
    public static void main(String[] args) {
        String correctPassword = "abc123";

        Scanner input = new Scanner(System.in);

        System.out.print("Skriv inn passord: ");

        String password = input.nextLine();

        if (password.equals(correctPassword)) {
            System.out.println("Passordet er riktig!");
        }
        else {
            System.out.println("Passordet er feil!");
        }
    }
}

