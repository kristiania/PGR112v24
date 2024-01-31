package lectures._06.exception;

public class JavaProgram
{
    public static void main(String[] args) {
        Event event = new Event(
                "Brettspill-kveld",
                "Vi samler oss for å spille brettspill!"
        );

        try {
            Participant deltager1 = new Participant("Bob", "1234567");

            event.addParticipant(deltager1);
        } catch (InputPhoneNotCorrectException e) {
            System.out.println("En feil oppstod!");

            e.printStackTrace();
        }

        System.out.println("Alt fungerer som det skal");
        System.out.println("Antall deltagere: " + event.getParticipants().size());
    }
}
