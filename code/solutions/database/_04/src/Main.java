package solutions.database._04.src;

public class Main
{
    public static void main(String[] args) {
        var terminal = new Terminal();

        // Main.testCreateUser(terminal);

        terminal.showMenu();
    }

    private static void testCreateUser(Terminal terminal) {
        String username = "test";
        String password = "test123";

        if (!terminal.userExists(username)) {
            System.out.println("Brukernavnet eksisterer ikke i databasen, la oss forsøke å lage den!");

            boolean userCreated = terminal.createUser(username, password);

            if (userCreated) {
                System.out.println("Brukeren ble opprettet og brukeren eksisterer!");

                System.out.println("Dobbeltsjekker ...");

                if (terminal.userExists(username)) {
                    System.out.println("Brukeren ble funnet i databasen!");
                }
                else {
                    System.out.println("Brukere ble ikke funnet i databasen, merkelig!");
                }
            }
            else {
                System.out.println("Hmm, brukeren ble ikke opprettet!");
            }
        }
        else {
            System.out.println(STR."Brukeren \"\{username}\" eksisterer allerede i databasen!");
        }
    }
}
